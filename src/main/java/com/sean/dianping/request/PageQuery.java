package com.sean.dianping.request;

import lombok.Data;

@Data
public class PageQuery {

    private Integer page = 1;

    private Integer size = 20;
}
