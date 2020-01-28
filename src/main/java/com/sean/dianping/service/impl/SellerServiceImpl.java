package com.sean.dianping.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sean.dianping.bean.Seller;
import com.sean.dianping.common.BusinessException;
import com.sean.dianping.common.EmBusinessError;
import com.sean.dianping.mapper.SellerMapper;
import com.sean.dianping.service.SellerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
    public IPage<Seller> selectAll(int current, int size) {
        Page<Seller> page = new Page<Seller>(current, size);
        return this.page(page);

    }

    @Override
    public Seller changeStatus(Integer id, Integer disabledFlag) {
        Seller sellerModel = this.getById(id);
        sellerModel.setUpdatedAt(null);
        if (sellerModel == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        sellerModel.setDisabledFlag(disabledFlag);
        this.updateById(sellerModel);
        return sellerModel;
    }
}
