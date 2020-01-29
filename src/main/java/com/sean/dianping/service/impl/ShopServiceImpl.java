package com.sean.dianping.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sean.dianping.bean.CategoryModel;
import com.sean.dianping.bean.SellerModel;
import com.sean.dianping.bean.ShopModel;
import com.sean.dianping.common.BusinessException;
import com.sean.dianping.common.EmBusinessError;
import com.sean.dianping.dto.ShopDto;
import com.sean.dianping.mapper.ShopMapper;
import com.sean.dianping.service.CategoryService;
import com.sean.dianping.service.SellerService;
import com.sean.dianping.service.ShopService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author yinhaixiang
 * @since 2020-01-28
 */
@Service
public class ShopServiceImpl extends ServiceImpl<ShopMapper, ShopModel> implements ShopService {

    @Autowired
    private ShopMapper shopMapper;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SellerService sellerService;

    @Override
    public ShopModel create(ShopModel shopModel) {
        //校验商家是否存在正确
        SellerModel sellerModel = sellerService.getById(shopModel.getSellerId());
        if (sellerModel == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "商户不存在");
        }

        if (sellerModel.getDisabledFlag().intValue() == 1) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "商户已禁用");
        }

        //校验类目
        CategoryModel categoryModel = categoryService.getById(shopModel.getCategoryId());
        if (categoryModel == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "类目不存在");
        }
        this.save(shopModel);

        return get(shopModel.getId());
    }

    @Override
    public ShopDto get(Integer id) {
        ShopModel shopModel = this.getById(id);
        if (shopModel == null) {
            return null;
        }
        ShopDto shopDto = ShopDto.fromModel(shopModel);
        shopDto.setSellerModel(sellerService.getById(shopModel.getSellerId()));
        shopDto.setCategoryModel(categoryService.getById(shopModel.getCategoryId()));
        return shopDto;
    }

    @Override
    public IPage<ShopDto> selectAll(int current, int size) {
        Page<ShopModel> page = new Page<ShopModel>(current, size);
        Page<ShopModel> pageResult = this.page(page);

        List<ShopModel> shopModelList = pageResult.getRecords();
        List<ShopDto> shopDtoList = new ArrayList<>();

        shopModelList.forEach(shopModel -> {
            ShopDto shopDto = ShopDto.fromModel(shopModel);
            shopDto.setSellerModel(sellerService.getById(shopModel.getSellerId()));
            shopDto.setCategoryModel(categoryService.getById(shopModel.getCategoryId()));
        });

        Page<ShopDto> result = new Page<>();
        result.setRecords(shopDtoList);
        result.setTotal(pageResult.getTotal());
        result.setSize(pageResult.getSize());
        result.setCurrent(current);
        result.setPages(pageResult.getPages());

        return result;
    }

    @Override
    public List<ShopDto> recommend(BigDecimal longitude, BigDecimal latitude) {
        List<ShopModel> shopModelList = shopMapper.recommend(longitude, latitude);
        List<ShopDto> shopDtoList = new ArrayList<>();

        shopModelList.forEach(shopModel -> {
            ShopDto shopDto = ShopDto.fromModel(shopModel);
            shopDto.setSellerModel(sellerService.getById(shopModel.getSellerId()));
            shopDto.setCategoryModel(categoryService.getById(shopModel.getCategoryId()));
        });
        return shopDtoList;
    }

    @Override
    public List<Map<String, Object>> searchGroupByTags(String keyword, Integer categoryId, String tags) {
        return shopMapper.searchGroupByTags(keyword, categoryId, tags);
    }

    @Override
    public List<ShopDto> search(BigDecimal longitude, BigDecimal latitude, String keyword, Integer orderby, Integer categoryId, String tags) {
        List<ShopModel> shopModelList = shopMapper.search(longitude, latitude, keyword, orderby, categoryId, tags);
        List<ShopDto> shopDtoList = new ArrayList<>();

        shopModelList.forEach(shopModel -> {
            ShopDto shopDto = ShopDto.fromModel(shopModel);
            shopDto.setSellerModel(sellerService.getById(shopModel.getSellerId()));
            shopDto.setCategoryModel(categoryService.getById(shopModel.getCategoryId()));
        });
        return shopDtoList;
    }
}
