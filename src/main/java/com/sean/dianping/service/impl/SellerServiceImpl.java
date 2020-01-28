package com.sean.dianping.service.impl;

import com.sean.dianping.bean.Seller;
import com.sean.dianping.mapper.SellerMapper;
import com.sean.dianping.service.SellerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author yinhaixiang
 * @since 2020-01-28
 */
@Service
public class SellerServiceImpl extends ServiceImpl<SellerMapper, Seller> implements SellerService {

    @Override
    public Seller create(Seller sellerModel) {
        return null;
    }

    @Override
    public Seller get(Integer id) {
        return null;
    }

    @Override
    public List<Seller> selectAll() {
        return null;
    }

    @Override
    public Seller changeStatus(Integer id, Integer disabledFlag) {
        return null;
    }
}
