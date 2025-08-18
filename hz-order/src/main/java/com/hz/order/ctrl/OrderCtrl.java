package com.hz.order.ctrl;

import com.hz.base.api.OrderApi;
import com.hz.base.entity.OrderInfo;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author rhb
 * @date 2025-08-18 星期一 18:48:08
 * @description
 */
@RestController
public class OrderCtrl implements OrderApi {
    @Override
    public List<OrderInfo> orderInfoByTid(String tid) {
        return null;
    }

    @Override
    public Boolean placeOrder() {
        return null;
    }
}
