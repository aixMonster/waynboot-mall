package com.wayn.mobile.api.controller.callback;

import com.alibaba.fastjson.JSON;
import com.wayn.common.core.service.shop.IMobileOrderService;
import com.wayn.data.redis.constant.RedisKeyEnum;
import com.wayn.data.redis.manager.RedisCache;
import com.wayn.message.core.dto.OrderDTO;
import com.wayn.util.exception.BusinessException;
import com.wayn.util.util.R;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 下单回调接口
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("callback/order")
public class SubmitOrderController {

    private IMobileOrderService iMobileOrderService;
    private RedisCache redisCache;

    /**
     * 回调下单
     *
     * @param order 订单数据传输对象
     * @return R
     */
    @PostMapping("submit")
    public R submit(String order) {
        log.info("callback order request is {}", order);
        OrderDTO orderDTO = JSON.parseObject(order, OrderDTO.class);
        try {
            iMobileOrderService.submit(orderDTO);
            redisCache.setCacheObject(RedisKeyEnum.ORDER_RESULT_KEY.getKey(orderDTO.getOrderSn()),
                    "success", RedisKeyEnum.ORDER_RESULT_KEY.getExpireSecond());
            return R.success();
        } catch (Exception e) {
            String errorMsg = "error";
            if (e instanceof BusinessException businessException) {
                errorMsg = businessException.getMsg();
            }
            redisCache.setCacheObject(RedisKeyEnum.ORDER_RESULT_KEY.getKey(orderDTO.getOrderSn()),
                    errorMsg, RedisKeyEnum.ORDER_RESULT_KEY.getExpireSecond());
            log.error(e.getMessage(), e);
            return R.error();
        }
    }
}
