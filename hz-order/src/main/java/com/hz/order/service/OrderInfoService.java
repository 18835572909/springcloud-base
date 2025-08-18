package com.hz.order.service;

import com.hz.base.entity.OrderInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hz.base.request.CreateOrderRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author renhuibo
 * @since 2025-08-18
 */
public interface OrderInfoService extends IService<OrderInfo> {

    void createOrder(CreateOrderRequest createOrderRequest);

}
