package com.sean.dianping.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sean.dianping.dto.ShopDto;
import com.sean.dianping.service.CategoryService;
import com.sean.dianping.service.SellerService;
import com.sean.dianping.service.ShopService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopServiceImplTest {

    @Resource
    private ShopService shopService;

    @Test
    public void create() {
    }

    @Test
    public void get() {
    }

    @Test
    public void selectAll() {
        IPage<ShopDto> result = shopService.selectAll(1, 5);
        System.out.println(result);

    }

    @Test
    public void recommend() {
    }

    @Test
    public void searchGroupByTags() {
    }

    @Test
    public void search() {
    }
}