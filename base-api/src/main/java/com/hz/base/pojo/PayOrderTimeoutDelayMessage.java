package com.hz.base.pojo;

import lombok.Data;

/**
 * @author rhb
 * @date 2025-08-18 星期一 19:12:13
 * @description
 */
@Data
public class PayOrderTimeoutDelayMessage {

    private String orderId;

    /*业务标识*/
    private String businessIdentifier;

    /*取消类型*/
    private String orderType;

    /*用户id*/
    private String userId;

    /*订单状态*/
    private String orderStatus;


}
