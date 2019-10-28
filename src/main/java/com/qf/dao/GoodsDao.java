package com.qf.dao;

import com.qf.pojo.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public  interface GoodsDao {

    // 添加商品

    void addGoods(Goods goods);

   // 查询所有商品
    List<Goods> findGoodsAll();

    // 根据id查询商品信息
    Goods findGoodsByid(@Param("id") Integer id);

    // 修改商品
    void updateGoods(Goods goods);

}
