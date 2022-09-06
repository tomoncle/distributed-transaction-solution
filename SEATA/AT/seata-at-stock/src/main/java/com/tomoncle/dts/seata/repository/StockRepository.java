package com.tomoncle.dts.seata.repository;

import com.tomoncle.dts.seata.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Description：
 *
 * @author fangliangsheng
 * @date 2019-04-04
 */
public interface StockRepository extends JpaRepository<Stock, String> {

    Stock findByCommodityCode(String commodityCode);

}
