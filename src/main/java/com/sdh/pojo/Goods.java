package com.sdh.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @ClassName Goods
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/10/23 11:38
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
    private Integer id;
    private Integer tid;
    private String goodsName;
    private String picture;
    private String pictureDetail;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pubdate;
    private BigDecimal price;
    private Double weight;
    private String intro;
    private String detail;
    private Integer show;
    private MultipartFile pic;
    /**
     * 一对多查询
     */
    private GoodsType goodsType;
    private List<GoodsType> goodsTypeList;
}
