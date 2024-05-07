package com.wayn.common.request;

import lombok.Data;

/**
 * 搜索查询VO对象
 */
@Data
public class SearchRequestVO {

    private String keyword;

    private Integer categoryId;

    private Integer brandId;

    private Boolean isNew;

    private Boolean isHot;

    private Boolean filterNew;

    private Boolean filterHot;

    private Boolean isSales;

    private Boolean isPrice;

    private String orderBy;
}
