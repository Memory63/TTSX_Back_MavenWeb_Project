package com.sdh.dao;

import com.sdh.pojo.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName GoodsDao
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/10/26 22:13
 * @Version 1.0
 */
public interface GoodsDao {

    /**
     * todo: 查询所有商品
     * @return
     */
    List<Goods> queryGoods();

    void addGoods(Goods goods);

    void deleteGoods(@Param("id") Integer id);

    Goods queryGoodsById(@Param("id") Integer id);

    void updateGoodsById(Goods goods);
}
