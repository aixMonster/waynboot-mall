package com.wayn.common.core.mapper.shop;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wayn.common.core.entity.shop.GoodsProduct;

/**
 * 商品货品表 Mapper 接口
 *
 * @author wayn
 * @since 2020-07-06
 */
public interface GoodsProductMapper extends BaseMapper<GoodsProduct> {

    boolean addStock(Long productId, Integer number);

    boolean reduceStock(Long productId, Integer number);
}
