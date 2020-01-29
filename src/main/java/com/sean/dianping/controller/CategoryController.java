package com.sean.dianping.controller;

import com.sean.dianping.bean.CategoryModel;
import com.sean.dianping.common.CommonRes;
import com.sean.dianping.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author yinhaixiang
 */
@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @ResponseBody
    @RequestMapping("/list")
    public CommonRes list() {
        List<CategoryModel> categoryModelList = categoryService.list();
        return CommonRes.create(categoryModelList);

    }

}
