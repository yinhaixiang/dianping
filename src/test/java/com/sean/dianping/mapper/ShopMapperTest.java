package com.sean.dianping.mapper;

import com.sean.dianping.bean.ShopModel;
import com.sean.dianping.service.SellerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopMapperTest {

    @Autowired
    private ShopMapper shopMapper;


    @Test
    public void recommend() {
        List<ShopModel> result = shopMapper.recommend(new BigDecimal(2), new BigDecimal(3));
        System.out.println(result);
    }

//    @Test
//    public void searchGroupByTags() {
//        List<Map<String, Object>> result = shopMapper.searchGroupByTags("西", null, "帅哥多");
//        System.out.println(result);
//    }
}