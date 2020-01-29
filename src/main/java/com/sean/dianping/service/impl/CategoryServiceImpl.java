package com.sean.dianping.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sean.dianping.bean.CategoryModel;
import com.sean.dianping.bean.SellerModel;
import com.sean.dianping.mapper.CategoryMapper;
import com.sean.dianping.service.CategoryService;
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
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, CategoryModel> implements CategoryService {


    @Override
    public IPage<CategoryModel> selectAll(int current, int size) {
        Page<CategoryModel> page = new Page<CategoryModel>(current, size);
        return this.page(page);
    }
}
