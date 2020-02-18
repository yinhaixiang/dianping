package com.sean.dianping.mapper;

import com.sean.dianping.bean.ShopModel;
import com.sean.dianping.bean.UserModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void insert() {
        UserModel userModel = new UserModel();
        userModel.setNickName("sean").setPassword("123").setTelphone("134");
        int result = userMapper.insert(userModel);
        System.out.println(result);
    }

    @Test
    public void SelectById() {
        UserModel result = userMapper.selectById(1);
        System.out.println(result);
    }


}