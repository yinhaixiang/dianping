package com.sean.dianping.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sean.dianping.bean.CategoryModel;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sean.dianping.bean.CategoryModel;
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
public interface CategoryService extends IService<CategoryModel> {

    IPage<CategoryModel> selectAll(int current, int size);

}
