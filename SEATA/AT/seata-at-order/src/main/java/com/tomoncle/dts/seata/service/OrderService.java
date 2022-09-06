package com.tomoncle.dts.seata.service;

import com.tomoncle.dts.seata.entity.Order;
import com.tomoncle.dts.seata.feign.AccountFeignClient;
import com.tomoncle.dts.seata.repository.OrderRepository;
import io.seata.core.context.RootContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;


@Service
public class OrderService {
    private Logger logger = LoggerFactory.getLogger(OrderService.class);
    private final AccountFeignClient accountFeignClient;

    private final OrderRepository orderRepository;

    public OrderService(AccountFeignClient accountFeignClient, OrderRepository orderRepository) {
        this.accountFeignClient = accountFeignClient;
        this.orderRepository = orderRepository;
    }

    @Transactional
    public void create(String userId, String commodityCode, Integer count) {
        logger.info("分布式事务 XID: "+RootContext.getXID());
        BigDecimal orderMoney = new BigDecimal(count).multiply(new BigDecimal(5));

        Order order = new Order();
        order.setUserId(userId);
        order.setCommodityCode(commodityCode);
        order.setCount(count);
        order.setMoney(orderMoney);
        orderRepository.save(order);
        accountFeignClient.debit(userId, orderMoney);

    }

}
