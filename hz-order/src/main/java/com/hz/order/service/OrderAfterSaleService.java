package com.hz.order.service;

import com.hz.base.request.CancelOrderRequest;

/**
 * @author rhb
 * @date 2025-08-18 星期一 19:19:36
 * @description
 */
public interface OrderAfterSaleService {

     void cancelOrder(CancelOrderRequest cancelOrderRequest);
}
