package com.hz.base.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author renhuibo
 * @since 2025-08-18
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("order_info")
public class OrderInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 订单id
     */
    private String oid;

    /**
     * 交易id
     */
    private String tid;

    /**
     * 1688买家id
     */
    private Long buyerId;

    /**
     * 宝贝id
     */
    private Long itemId;

    /**
     * 宝贝skuid
     */
    private String skuId;

    /**
     * 宝贝sku展示名
     */
    private String skuDisplayName;

    /**
     * 下单数量
     */
    private Integer num;

    /**
     * 商品标题
     */
    private String title;

    /**
     * 售价（单位：分）
     */
    private Integer price;

    /**
     * 图片
     */
    private String picUrl;

    /**
     * 总金额
     */
    private BigDecimal totalFee;

    /**
     * 折扣金额
     */
    private BigDecimal discountFee;

    /**
     * 优惠券折扣
     */
    private BigDecimal couponFee;

    /**
     * 实付金额
     */
    private BigDecimal payment;

    /**
     * 订单创建时间
     */
    private LocalDateTime created;

    /**
     * 订单修改时间
     */
    private LocalDateTime modified;

    /**
     * 订单状态
     */
    private String status;

    /**
     * 运单号
     */
    private String logisticsCompanyNo;

    /**
     * 物流公司编码
     */
    private String logisticsCompanyCode;

    /**
     * 物流公司名称
     */
    private String logisticsCompanyName;

    /**
     * 自定义商品编码
     */
    private String outerIid;

    /**
     * 自定义sku编码
     */
    private String outerSkuId;

    /**
     * 付款时间
     */
    private LocalDateTime payTime;

    /**
     * 发货时间
     */
    private LocalDateTime consignTime;

    /**
     * 确认收货时间
     */
    private LocalDateTime receiveTime;

    /**
     * 订单完成/关闭时间
     */
    private LocalDateTime endTime;

    /**
     * 订单入库时间（系统内）
     */
    private LocalDateTime gmtCreated;

    /**
     * 订单修改时间（系统内）
     */
    private LocalDateTime gmtModified;

    /**
     * 预计发货时间
     */
    private LocalDateTime expectConsignTime;

    /**
     * 运费
     */
    private BigDecimal postFee;

    /**
     * 收件人唯一id
     */
    private String addressId;
}
