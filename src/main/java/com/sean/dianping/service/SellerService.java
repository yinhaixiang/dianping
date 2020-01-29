package com.sean.dianping.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sean.dianping.bean.SellerModel;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sean.dianping.bean.SellerModel;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author yinhaixiang
 * @since 2020-01-28
 */
public interface SellerService extends IService<SellerModel> {

    IPage<SellerModel> selectAll(int current, int size);

    SellerModel changeStatus(Integer id, Integer disabledFlag);


}
