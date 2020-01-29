package com.sean.dianping.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sean.dianping.bean.UserModel;
import com.sean.dianping.common.BusinessException;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author sean
 * @since 2020-01-26
 */
public interface UserService extends IService<UserModel> {

    /**
     * 注册用户
     *
     * @param registerUser
     * @return
     */
    UserModel register(UserModel registerUser);


    /**
     * 用户登录
     *
     * @param telphone
     * @param password
     * @return
     */
    UserModel login(String telphone, String password);

}
