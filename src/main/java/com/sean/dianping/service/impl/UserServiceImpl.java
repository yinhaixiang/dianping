package com.sean.dianping.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sean.dianping.bean.UserModel;
import com.sean.dianping.common.BusinessException;
import com.sean.dianping.common.EmBusinessError;
import com.sean.dianping.mapper.UserMapper;
import com.sean.dianping.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.misc.BASE64Encoder;

import javax.annotation.Resource;
import java.security.MessageDigest;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author yinhaixiang
 * @since 2020-01-29
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserModel> implements UserService {

    @Resource
    private UserMapper userMapper;

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

    @Override
    public UserModel mockitoGetUserById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public IPage<UserModel> selectAll(int current, int size) {
        Page<UserModel> page = new Page<UserModel>(current, size);
        return this.page(page);
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
