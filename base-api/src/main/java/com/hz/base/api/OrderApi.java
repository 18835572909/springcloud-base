package com.hz.base.api;

import com.hz.base.entity.OrderInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author rhb
 * @date 2025-08-18 星期一 17:55:03
 * @description
 */
@RequestMapping("/order")
public interface OrderApi {

    @RequestMapping(path = "/orderInfo",method = RequestMethod.GET)
    List<OrderInfo> orderInfoByTid(String tid);

    @RequestMapping(path = "/placeOrder",method = RequestMethod.POST)
    Boolean placeOrder();
}
