package com.qf.service;

import com.qf.pojo.Goods;

import java.util.List;

public interface GoodsService {

    // 添加商品
    void addGoods(Goods goods);

    // 查询所有商品

    List<Goods> selectGoodsAll();

    // 根据id查询商品信息
    Goods selectGoodsByid(Integer id);

    // 修改商品
    void updateGoodsById(Goods goods);
}
