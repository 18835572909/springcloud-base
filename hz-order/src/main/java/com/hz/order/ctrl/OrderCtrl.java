package com.hz.order.ctrl;

import com.hz.base.api.OrderApi;
import com.hz.base.entity.OrderInfo;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author rhb
 * @date 2025-08-18 星期一 18:48:08
 * @description
 */
@Slf4j
@RestController
public class OrderCtrl implements OrderApi {
    @Override
    public List<OrderInfo> orderInfoByTid(String tid) {
        return null;
    }

    @GlobalTransactional(timeoutMills = 300000, name = "spring-cloud-demo-tx")
    @Override
    public Boolean placeOrder() {
        String xid = RootContext.getXID();
        boolean gTransaction = RootContext.inGlobalTransaction();
        log.info("xid:{}, gTransaction:{}",xid, gTransaction);

        return null;
    }
}
