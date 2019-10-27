package com.sdh.controller;

import com.sdh.pojo.Goods;
import com.sdh.pojo.GoodsType;
import com.sdh.service.GoodsService;
import com.sdh.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.util.List;
import java.util.UUID;

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

    /**
     * todo: 查看商品
     * @param model
     * @return
     */
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
    public String addGoods(Goods goods){
        String uuid = UUID.randomUUID().toString();
        goods.setPicture("goods/"+uuid+"_"+goods.getPic().getOriginalFilename());
        //获取文件类型
        String fileType = goods.getPic().getContentType();
        String[] fileTypeArr = fileType.split("/");
        String type = "image";
        if(!type.equals(fileTypeArr[0])){
            return "3";
        }
        try {
            goods.getPic().transferTo(new File("images/goods/"+goods.getPicture()));
            goodsService.addGoods(goods);
            return "1";
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
    }

    /**
     * todo: 跳转到修改页面
     * @param id
     * @param model
     * @return
     */
    @GetMapping("updateGoods")
    public String updateGoodsPage(Integer id,Model model){
        Goods goods = goodsService.queryGoodsById(id);
        model.addAttribute("goods",goods);
        return "WEB-INF/modifyGoods";
    }

    /**
     * todo: 删除指定商品，返回是否成功
     * @param id
     * @return
     */
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
