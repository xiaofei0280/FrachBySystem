package com.qf.service;

import com.qf.dao.GoodsDao;
import com.qf.pojo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;

    @Override
    public void addGoods(Goods goods) {
         goodsDao.addGoods(goods);
    }

    @Override
    public List<Goods> selectGoodsAll() {
        List<Goods> goodslist = goodsDao.findGoodsAll();
        return goodslist;
    }

    @Override
    public Goods selectGoodsByid(Integer id) {
        Goods goods = goodsDao.findGoodsByid(id);
        return goods;
    }

    @Override
    public void updateGoodsById(Goods goods) {
        goodsDao.updateGoods(goods);
    }
}
