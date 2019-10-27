package com.sdh.service.impl;

import com.sdh.dao.GoodsDao;
import com.sdh.dao.GoodsTypeDao;
import com.sdh.pojo.Goods;
import com.sdh.pojo.GoodsType;
import com.sdh.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName GoodsServiceImpl
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/10/26 22:16
 * @Version 1.0
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private GoodsTypeDao goodsTypeDao;

    @Override
    public List<Goods> queryGoods() {
        List<Goods> goods = goodsDao.queryGoods();
        for (Goods good : goods) {
            good.setGoodsType(goodsTypeDao.queryGoodsTypeById(good.getTid()));
        }
        return  goods;
    }

    @Override
    public void addGoods(Goods goods) {
        goods.setId(null);
        goods.setPubdate(new Date());
        goods.setShow("0");
        goodsDao.addGoods(goods);
    }

    @Override
    public void deleteGoods(Integer id) {
        goodsDao.deleteGoods(id);
    }

    @Override
    public Goods queryGoodsById(Integer id) {
        Goods goods = goodsDao.queryGoodsById(id);
        GoodsType goodsType = goodsTypeDao.queryGoodsTypeById(goods.getTid());
        goods.setGoodsType(goodsType);
        return goods;
    }
}
