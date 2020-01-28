package com.sean.dianping.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sean.dianping.bean.Seller;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author yinhaixiang
 * @since 2020-01-28
 */
public interface SellerService extends IService<Seller> {

    Seller create(Seller sellerModel);

    Seller get(Integer id);

    IPage<Seller> selectAll(int current, int size);

    Seller changeStatus(Integer id, Integer disabledFlag);


}
