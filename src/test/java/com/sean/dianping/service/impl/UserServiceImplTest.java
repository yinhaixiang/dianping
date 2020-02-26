package com.sean.dianping.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sean.dianping.bean.CategoryModel;
import com.sean.dianping.bean.UserModel;
import com.sean.dianping.mapper.UserMapper;
import com.sean.dianping.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {


    @Autowired
    private UserService userService;


    @MockBean
    private UserMapper userMapper;


    @Test
    public void get() {
        UserModel result = userService.getById(1);
        System.out.println(result);
    }

    @Test
    @Rollback(false)
    public void create() {
        UserModel userModel = new UserModel();
        userModel.setGender(1);
        userModel.setNickName("sean");
        userModel.setPassword("sean");
        userModel.setTelphone("1");
        boolean result = userService.save(userModel);
        System.out.println(result);
    }


    @Test
    @Rollback(true)
    public void update() {
        UserModel userModel = userService.getById(12);
        userModel.setTelphone("132");
        userModel.setUpdatedAt(null);

        boolean result = userService.updateById(userModel);
        System.out.println(result);


    }

    @Test
    public void mockitoGetUserById() {
        UserModel userModel12 = new UserModel();
        userModel12.setId(1).setNickName("yinhaixiang");


        UserModel userModel100 = new UserModel();
        userModel100.setId(2).setNickName("hongkai");



        when(userMapper.selectById(12)).thenReturn(userModel12);
        when(userMapper.selectById(100)).thenReturn(userModel100);

        UserModel result = userService.mockitoGetUserById(100);
        System.out.println(result);
    }


    @Test
    public void selectAll() {
        IPage<UserModel> result = userService.selectAll(1, 5);
        System.out.println(result);
    }
}