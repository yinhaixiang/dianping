package com.sean.dianping.controller.admin;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sean.dianping.bean.CategoryModel;
import com.sean.dianping.common.AdminPermission;
import com.sean.dianping.common.BusinessException;
import com.sean.dianping.common.CommonUtil;
import com.sean.dianping.common.EmBusinessError;
import com.sean.dianping.request.CategoryCreateReq;
import com.sean.dianping.request.PageQuery;
import com.sean.dianping.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yinhaixiang
 */
@Controller("/admin/category")
@RequestMapping("/admin/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    //品类列表
    @RequestMapping("/index")
    @AdminPermission
    public ModelAndView index(PageQuery pageQuery) {
        int current = pageQuery.getPage();
        int size = pageQuery.getSize();

        IPage<CategoryModel> categoryModelPageInfo = categoryService.selectAll(current, size);

        // 转成前端需要的数据格式
        Map result = new HashMap();
        result.put("list", categoryModelPageInfo.getRecords());
        result.put("total", categoryModelPageInfo.getTotal());
        result.put("pageSize", categoryModelPageInfo.getSize());
        result.put("pageNum", categoryModelPageInfo.getCurrent());
        result.put("pages", categoryModelPageInfo.getPages());

        ModelAndView modelAndView = new ModelAndView("/admin/category/index.html");
        modelAndView.addObject("data", result);
        modelAndView.addObject("CONTROLLER_NAME", "category");
        modelAndView.addObject("ACTION_NAME", "index");
        return modelAndView;
    }

    @RequestMapping("/createpage")
    @AdminPermission
    public ModelAndView createPage() {
        ModelAndView modelAndView = new ModelAndView("/admin/category/create.html");
        modelAndView.addObject("CONTROLLER_NAME", "category");
        modelAndView.addObject("ACTION_NAME", "create");
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @AdminPermission
    public String create(@Valid CategoryCreateReq categoryCreateReq, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, CommonUtil.processErrorString(bindingResult));
        }

        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setName(categoryCreateReq.getName());
        categoryModel.setIconUrl(categoryCreateReq.getIconUrl());
        categoryModel.setSort(categoryCreateReq.getSort());

        categoryService.save(categoryModel);

        return "redirect:/admin/category/index";


    }

}
