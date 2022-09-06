package com.tomoncle.dts.seata.service;

import com.tomoncle.dts.seata.entity.Stock;
import com.tomoncle.dts.seata.repository.StockRepository;
import io.seata.core.context.RootContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Description：
 *
 * @author fangliangsheng
 * @date 2019-04-04
 */
@Service
public class StockService {
    private Logger logger = LoggerFactory.getLogger(StockService.class);
    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Transactional
    public void deduct(String commodityCode, int count) {
        logger.info("分布式事务 XID: "+RootContext.getXID());
        Stock stock = stockRepository.findByCommodityCode(commodityCode);
        stock.setCount(stock.getCount() - count);

        stockRepository.save(stock);
    }
}
