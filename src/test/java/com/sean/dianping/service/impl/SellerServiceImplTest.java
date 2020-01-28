package com.sean.dianping.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sean.dianping.bean.Seller;
import com.sean.dianping.service.SellerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerServiceImplTest {

    @Autowired
    private SellerService sellerService;

    @Test
    public void create() {
    }

    @Test
    public void get() {
    }

    @Test
    public void selectAll() {
        IPage<Seller> result = sellerService.selectAll(2, 5);
        System.out.println(result);

    }

    @Test
    public void changeStatus() {
    }
}