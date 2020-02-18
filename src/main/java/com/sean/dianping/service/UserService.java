package com.sean.dianping.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sean.dianping.bean.UserModel;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author yinhaixiang
 * @since 2020-01-29
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


    UserModel mockitoGetUserById(Integer id);


    IPage<UserModel> selectAll(int current, int size);

}
