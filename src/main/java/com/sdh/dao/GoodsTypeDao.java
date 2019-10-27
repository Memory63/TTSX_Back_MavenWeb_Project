package com.sdh.dao;

import com.sdh.pojo.GoodsType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName GoodsTypeDao
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/10/26 22:23
 * @Version 1.0
 */
public interface GoodsTypeDao {
    List<GoodsType> queryGoodsType();

    GoodsType queryGoodsTypeById(@Param("id") Integer id);
}
