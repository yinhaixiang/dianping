package com.sean.dianping.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sean.dianping.bean.SellerModel;
import com.sean.dianping.common.BusinessException;
import com.sean.dianping.common.EmBusinessError;
import com.sean.dianping.mapper.SellerMapper;
import com.sean.dianping.service.SellerService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author yinhaixiang
 * @since 2020-01-28
 */
@Service
public class SellerServiceImpl extends ServiceImpl<SellerMapper, SellerModel> implements SellerService {

    @Override
    public IPage<SellerModel> selectAll(int current, int size) {
        Page<SellerModel> page = new Page<SellerModel>(current, size);
        return this.page(page);
    }

    @Override
    public SellerModel changeStatus(Integer id, Integer disabledFlag) {
        SellerModel sellerModel = this.getById(id);
        sellerModel.setUpdatedAt(null);
        if (sellerModel == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        sellerModel.setDisabledFlag(disabledFlag);
        this.updateById(sellerModel);
        return sellerModel;
    }
}
