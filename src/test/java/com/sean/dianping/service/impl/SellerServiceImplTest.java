package com.sean.dianping.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sean.dianping.bean.SellerModel;
import com.sean.dianping.service.SellerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerServiceImplTest {

    @Autowired
    private SellerService sellerService;

    @Test
    @Rollback(false)
    public void create() {
        SellerModel seller = new SellerModel();
        seller.setName("sean");
        boolean result = sellerService.save(seller);
        System.out.println(result);
    }

    @Test
    public void selectAll() {
        IPage<SellerModel> result = sellerService.selectAll(2, 5);
        System.out.println(result);

    }

    @Test
    @Rollback(false)
    public void changeStatus() {
        SellerModel result = sellerService.changeStatus(29, 2);
        System.out.println(result);
    }


}