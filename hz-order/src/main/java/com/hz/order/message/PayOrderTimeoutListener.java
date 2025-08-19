package com.hz.order.message;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.hz.base.entity.OrderInfo;
import com.hz.base.pojo.PayOrderTimeoutDelayMessage;
import com.hz.base.request.CancelOrderRequest;
import com.hz.order.mapper.OrderInfoMapper;
import com.hz.order.service.OrderAfterSaleService;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author rhb
 * @date 2025-08-18 星期一 19:09:41
 * @description MQ消费
 */
@Slf4j
public class PayOrderTimeoutListener {

    @Resource
    OrderAfterSaleService orderAfterSaleService;

    @Resource
    OrderInfoMapper orderInfoMapper;

    public Boolean orderHandler(PayOrderTimeoutDelayMessage payOrderTimeoutDelayMessage){
        //消费延迟消息，执行关单逻辑
        CancelOrderRequest cancelOrderRequest = new CancelOrderRequest();
        cancelOrderRequest.setOrderId(payOrderTimeoutDelayMessage.getOrderId());
        cancelOrderRequest.setBusinessIdentifier(payOrderTimeoutDelayMessage.getBusinessIdentifier());
        cancelOrderRequest.setCancelType(payOrderTimeoutDelayMessage.getOrderType());
        cancelOrderRequest.setUserId(payOrderTimeoutDelayMessage.getUserId());
        cancelOrderRequest.setOrderType(payOrderTimeoutDelayMessage.getOrderType());
        cancelOrderRequest.setOrderStatus(payOrderTimeoutDelayMessage.getOrderStatus());
        //查询当前数据库的订单实时状态
        OrderInfo orderInfo = new LambdaQueryChainWrapper<>(orderInfoMapper)
                .eq(OrderInfo::getTid, payOrderTimeoutDelayMessage.getOrderId())
                .one();
        String orderStatusDatabase = orderInfo.getStatus();
        if (!"CREATED".equals(orderStatusDatabase)) {
            //订单实时状态不等于已创建
            return true;
        }

        //当前时间 小于 订单实际支付截止时间
//        if (new Date().before(orderInfoDO.getExpireTime())) {
//            return true;
//        }

        orderAfterSaleService.cancelOrder(cancelOrderRequest);
        log.info("关闭订单，orderId:{}", cancelOrderRequest.getOrderId());
        return true;
    }

}