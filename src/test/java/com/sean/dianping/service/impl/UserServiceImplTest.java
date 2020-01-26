package com.sean.dianping.service.impl;

import com.sean.dianping.bean.User;
import com.sean.dianping.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {


    @Autowired
    private UserService userService;


    @Test
    public void get() {
        User result = userService.getById(1);
        System.out.println(result);
    }

    @Test
    @Rollback(false)
    public void create() {
        User user = new User();
        user.setGender(1);
        user.setNickName("sean");
        user.setPassword("sean");
        user.setTelphone("136");
        boolean result = userService.save(user);
        System.out.println(result);
    }


    @Test
    @Rollback(false)
    public void update() {
        User user = userService.getById(4);
        user.setTelphone("132");
        user.setUpdatedAt(null);

        boolean result = userService.updateById(user);
        System.out.println(result);


    }
}