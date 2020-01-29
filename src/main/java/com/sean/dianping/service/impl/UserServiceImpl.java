package com.sean.dianping.service.impl;

import com.sean.dianping.bean.UserModel;
import com.sean.dianping.common.BusinessException;
import com.sean.dianping.common.EmBusinessError;
import com.sean.dianping.mapper.UserMapper;
import com.sean.dianping.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author sean
 * @since 2020-01-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserModel> implements UserService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserModel register(UserModel registerUser) {
        registerUser.setPassword(encodeByMd5(registerUser.getPassword()));
        this.save(registerUser);
        return this.getById(registerUser.getId());
    }

    @Override
    public UserModel login(String telphone, String password) {
        UserModel userModel = this.lambdaQuery().eq(UserModel::getTelphone, telphone).eq(UserModel::getPassword, encodeByMd5(password)).one();
        if (userModel == null) {
            throw new BusinessException(EmBusinessError.LOGIN_FAIL);
        }
        return userModel;
    }


    private String encodeByMd5(String str) {
        try {
            //确认计算方法MD5
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            BASE64Encoder base64Encoder = new BASE64Encoder();
            return base64Encoder.encode(messageDigest.digest(str.getBytes("utf-8")));
        } catch (Exception e) {
            throw new BusinessException(EmBusinessError.MD5_ERROR);
        }
    }
}
