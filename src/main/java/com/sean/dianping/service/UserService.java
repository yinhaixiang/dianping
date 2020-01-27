package com.sean.dianping.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sean.dianping.bean.User;
import com.sean.dianping.common.BusinessException;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sean
 * @since 2020-01-26
 */
public interface UserService extends IService<User> {

    /**
     * 注册用户
     * @param registerUser
     * @return
     */
    User register(User registerUser);
}
