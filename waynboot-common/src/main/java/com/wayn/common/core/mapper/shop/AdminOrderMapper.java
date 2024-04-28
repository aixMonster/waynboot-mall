package com.wayn.common.core.mapper.shop;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wayn.common.core.entity.shop.Order;
import com.wayn.common.response.OrderManagerResVO;

/**
 * 类目表 Mapper 接口
 *
 * @author wayn
 * @since 2020-06-26
 */
public interface AdminOrderMapper extends BaseMapper<Order> {

    IPage<OrderManagerResVO> selectOrderListPage(IPage<Order> page, Order order);
}
