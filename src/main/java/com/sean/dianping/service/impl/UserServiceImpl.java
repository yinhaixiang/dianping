package com.sean.dianping.service.impl;

import com.sean.dianping.bean.User;
import com.sean.dianping.mapper.UserMapper;
import com.sean.dianping.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sean
 * @since 2020-01-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
