package com.qf.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    private Integer id;
    private Integer goodsid;
    private Integer num;
    private BigDecimal money;
    private Integer uid;
}