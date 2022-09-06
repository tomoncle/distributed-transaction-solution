package com.tomoncle.dts.seata.service;

import com.tomoncle.dts.seata.feign.OrderFeignClient;
import com.tomoncle.dts.seata.feign.StockFeignClient;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BusinessService {
    private Logger logger = LoggerFactory.getLogger(BusinessService.class);
    private final StockFeignClient stockFeignClient;
    private final OrderFeignClient orderFeignClient;

    public BusinessService(StockFeignClient stockFeignClient, OrderFeignClient orderFeignClient) {
        this.stockFeignClient = stockFeignClient;
        this.orderFeignClient = orderFeignClient;
    }

    /**
     * 减库存，下订单
     */
    @GlobalTransactional
    public void purchase(String userId, String commodityCode, int orderCount) {
        logger.info("分布式事务 XID: " + RootContext.getXID());
        stockFeignClient.deduct(commodityCode, orderCount);
        orderFeignClient.create(userId, commodityCode, orderCount);
    }
}
