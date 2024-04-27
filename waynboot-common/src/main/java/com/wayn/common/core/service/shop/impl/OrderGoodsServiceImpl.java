package com.wayn.common.core.service.shop.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wayn.common.core.entity.shop.OrderGoods;
import com.wayn.common.core.mapper.shop.OrderGoodsMapper;
import com.wayn.common.core.service.shop.IOrderGoodsService;
import org.springframework.stereotype.Service;

/**
 * 订单商品表 服务实现类
 *
 * @author wayn
 * @since 2020-08-11
 */
@Service
public class OrderGoodsServiceImpl extends ServiceImpl<OrderGoodsMapper, OrderGoods> implements IOrderGoodsService {

}
