package com.sean.dianping.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sean.dianping.bean.ShopModel;
import com.sean.dianping.dto.ShopDto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author yinhaixiang
 * @since 2020-01-28
 */
public interface ShopService extends IService<ShopModel> {

    ShopModel create(ShopModel shopModel);

    ShopDto get(Integer id);

    List<ShopDto> selectAll();

    List<ShopDto> recommend(BigDecimal longitude, BigDecimal latitude);

    List<Map<String, Object>> searchGroupByTags(String keyword, Integer categoryId, String tags);

    List<ShopDto> search(BigDecimal longitude, BigDecimal latitude,
                           String keyword, Integer orderby, Integer categoryId, String tags);


}
