package com.sdh.controller;

import com.sdh.pojo.Goods;
import com.sdh.pojo.GoodsType;
import com.sdh.service.GoodsService;
import com.sdh.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName GoodsController
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/10/26 22:12
 * @Version 1.0
 */
@Controller
@RequestMapping("goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private GoodsTypeService goodsTypeService;

    @GetMapping("showGoods")
    public String showGoodsPage(Model model){
        List<Goods> goods = goodsService.queryGoods();
        model.addAttribute("goodsList",goods);
        return "WEB-INF/showGoods";
    }

    /**
     * todo: 跳转到添加商品页面
     * @param model
     * @return
     */
    @GetMapping("addGoods")
    public String addGoodsPage(Model model){
        List<GoodsType> goodsTypes = goodsTypeService.queryGoodsType();
        model.addAttribute("goodsType",goodsTypes);
        return "WEB-INF/addGoods";
    }

    /**
     * todo: 添加商品
     * @param goods
     * @return
     */
    @PostMapping("addGoods")
    @ResponseBody
    public String addGoods(@RequestBody Goods goods){
        System.out.println(goods);
        try {
//            goodsService.addGoods(goods);
            return "1";
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
    }

    @GetMapping("updateGoods")
    public String updateGoodsPage(Integer id,Model model){
        Goods goods = goodsService.queryGoodsById(id);
        model.addAttribute("goods",goods);
        return "WEB-INF/modifyGoods";
    }

    @GetMapping("deleteGoods")
    @ResponseBody
    public String deleteGoods(Integer id){
        System.out.println(id);
        try {
            goodsService.deleteGoods(id);
            System.out.println("删除成功");
            return "1";
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
    }
}
