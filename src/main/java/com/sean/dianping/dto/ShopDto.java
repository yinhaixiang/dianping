package com.sean.dianping.dto;

import com.sean.dianping.bean.CategoryModel;
import com.sean.dianping.bean.SellerModel;
import com.sean.dianping.bean.ShopModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.modelmapper.ModelMapper;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ShopDto extends ShopModel {
    private SellerModel sellerModel;

    private CategoryModel categoryModel;

    private static ModelMapper modelMapper = new ModelMapper();

    public static ShopDto fromModel(ShopModel shopModel) {
        return modelMapper.map(shopModel, ShopDto.class);
    }

}
