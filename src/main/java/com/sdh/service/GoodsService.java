package com.sdh.service;

import com.sdh.pojo.Goods;

import java.util.List;

/**
 * @ClassName GoodsService
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/10/26 22:15
 * @Version 1.0
 */
public interface GoodsService {
    /**
     * todo: 查询所有商品
     * @return
     */
    List<Goods> queryGoods();

    void addGoods(Goods goods);

    void deleteGoods(Integer id);

    Goods queryGoodsById(Integer id);
}
