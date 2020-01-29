package com.sean.dianping.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SellerCreateReq {
    @NotBlank(message = "商户名不能为空")
    private String name;

}
