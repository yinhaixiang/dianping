package com.sean.dianping.controller.admin;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sean.dianping.bean.ShopModel;
import com.sean.dianping.common.AdminPermission;
import com.sean.dianping.common.BusinessException;
import com.sean.dianping.common.CommonUtil;
import com.sean.dianping.common.EmBusinessError;
import com.sean.dianping.dto.ShopDto;
import com.sean.dianping.request.PageQuery;
import com.sean.dianping.request.ShopCreateReq;
import com.sean.dianping.service.ShopService;
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
@Controller("/admin/shop")
@RequestMapping("/admin/shop")
public class ShopController {
    @Autowired
    private ShopService shopService;

    @RequestMapping("/index")
    @AdminPermission
    public ModelAndView index(PageQuery pageQuery) {
        int current = pageQuery.getPage();
        int size = pageQuery.getSize();

        IPage<ShopDto> shopModelPageInfo = shopService.selectAll(current, size);

        // 转成前端需要的数据格式
        Map result = new HashMap();
        result.put("list", shopModelPageInfo.getRecords());
        result.put("total", shopModelPageInfo.getTotal());
        result.put("pageSize", shopModelPageInfo.getSize());
        result.put("pageNum", shopModelPageInfo.getCurrent());
        result.put("pages", shopModelPageInfo.getPages());

        ModelAndView modelAndView = new ModelAndView("/admin/shop/index.html");
        modelAndView.addObject("data", result);
        modelAndView.addObject("CONTROLLER_NAME", "shop");
        modelAndView.addObject("ACTION_NAME", "index");
        return modelAndView;
    }

    @RequestMapping("/createpage")
    @AdminPermission
    public ModelAndView createPage() {
        ModelAndView modelAndView = new ModelAndView("/admin/shop/create.html");
        modelAndView.addObject("CONTROLLER_NAME", "shop");
        modelAndView.addObject("ACTION_NAME", "create");
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @AdminPermission
    public String create(@Valid ShopCreateReq shopCreateReq, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, CommonUtil.processErrorString(bindingResult));
        }
        ShopModel shopModel = new ShopModel();
        shopModel.setIconUrl(shopCreateReq.getIconUrl());
        shopModel.setAddress(shopCreateReq.getAddress());
        shopModel.setCategoryId(shopCreateReq.getCategoryId());
        shopModel.setEndTime(shopCreateReq.getEndTime());
        shopModel.setStartTime(shopCreateReq.getStartTime());
        shopModel.setLongitude(shopCreateReq.getLongitude());
        shopModel.setLatitude(shopCreateReq.getLatitude());
        shopModel.setName(shopCreateReq.getName());
        shopModel.setPricePerMan(shopCreateReq.getPricePerMan());
        shopModel.setSellerId(shopCreateReq.getSellerId());

        shopService.create(shopModel);


        return "redirect:/admin/shop/index";


    }

}