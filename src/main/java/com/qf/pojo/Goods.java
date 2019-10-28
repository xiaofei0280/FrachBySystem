package com.qf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
    private Integer id;
    private String name;
    private String imgpath;
    private BigDecimal price;
    private Integer typeId;
    private String bigimgpath;
    private String detail;
    private Date creatTime;


}
