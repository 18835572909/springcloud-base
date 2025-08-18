package com.hz.order.service.impl;

import com.hz.base.dto.CalculateOrderAmountDTO;
import com.hz.base.dto.CreateOrderDTO;
import com.hz.base.dto.ProductSkuDTO;
import com.hz.base.entity.OrderInfo;
import com.hz.base.request.CreateOrderRequest;
import com.hz.order.mapper.OrderInfoMapper;
import com.hz.order.service.OrderInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author renhuibo
 * @since 2025-08-18
 */
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements OrderInfoService {

    @Override
    public void createOrder(CreateOrderRequest createOrderRequest) {
        //1.入参检查
        checkCreateOrderRequestParam(createOrderRequest);
        //2.风控检查
        checkRisk(createOrderRequest);
        //3.获取商品信息
        List<ProductSkuDTO> productSkuList = listProductSkus(createOrderRequest);
        //4.计算订单价格
        CalculateOrderAmountDTO calculateOrderAmountDTO = calculateOrderAmount(createOrderRequest, productSkuList);
        //5.验证订单实付金额
        checkRealPayAmount(createOrderRequest, calculateOrderAmountDTO);
        //6.锁定优惠券
        lockUserCoupon(createOrderRequest);
        //7.锁定商品库存
        lockProductStock(createOrderRequest);
        //8.生成订单到数据库
        addNewOrder(createOrderRequest, productSkuList, calculateOrderAmountDTO);
        //9.发送订单延迟消息用于支付超时自动关单
        sendPayOrderTimeoutDelayMessage(createOrderRequest);
        //返回订单信息
        CreateOrderDTO createOrderDTO = new CreateOrderDTO();

        createOrderDTO.setOrderId(createOrderRequest.getOrderId());
    }

    private void checkCreateOrderRequestParam(CreateOrderRequest createOrderDTO){}

    private void checkRisk(CreateOrderRequest createOrderDTO){}

    private List<ProductSkuDTO> listProductSkus(CreateOrderRequest createOrderDTO){return null;}

    private CalculateOrderAmountDTO calculateOrderAmount(CreateOrderRequest createOrderDTO, List<ProductSkuDTO> productSkuList){return null;}

    private void checkRealPayAmount(CreateOrderRequest createOrderDTO,CalculateOrderAmountDTO calculateOrderAmountDTO){}

    private void lockUserCoupon(CreateOrderRequest createOrderDTO){}

    private void lockProductStock(CreateOrderRequest createOrderDTO){}

    private void addNewOrder(CreateOrderRequest createOrderDTO, List<ProductSkuDTO> productSkuList, CalculateOrderAmountDTO calculateOrderAmountDTO){}

    private void sendPayOrderTimeoutDelayMessage(CreateOrderRequest createOrderDTO){
        /*
        PayOrderTimeoutDelayMessage message = new PayOrderTimeoutDelayMessage();
        message.setOrderId(createOrderRequest.getOrderId());
        message.setBusinessIdentifier(createOrderRequest.getBusinessIdentifier());
        message.setCancelType(OrderCancelTypeEnum.TIMEOUT_CANCELED.getCode());
        message.setUserId(createOrderRequest.getUserId());
        message.setOrderType(createOrderRequest.getOrderType());
        message.setOrderStatus(OrderStatusEnum.CREATED.getCode());
        String msgJson = JsonUtil.object2Json(message);
        defaultProducer.sendMessage(
                RocketMqConstant.PAY_ORDER_TIMEOUT_DELAY_TOPIC,
                msgJson,
                RocketDelayedLevel.DELAYED_30m,
                "支付订单超时延迟消息"
        );
        */
    }

}
