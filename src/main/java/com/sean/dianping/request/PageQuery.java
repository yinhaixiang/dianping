package com.sean.dianping.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageQuery {

    private Integer page = 1;

    private Integer size = 20;
}
