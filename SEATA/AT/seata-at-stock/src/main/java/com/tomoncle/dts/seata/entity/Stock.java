package com.tomoncle.dts.seata.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "stock_tbl")
@DynamicUpdate
@DynamicInsert
@Data
public class Stock {

    @Id
    private Long id;
    private String commodityCode;
    private Integer count;
}
