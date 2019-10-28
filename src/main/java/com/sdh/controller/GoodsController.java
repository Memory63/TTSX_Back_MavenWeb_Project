package com.sdh.controller;

import com.sdh.pojo.Goods;
import com.sdh.pojo.GoodsType;
import com.sdh.service.GoodsService;
import com.sdh.service.GoodsTypeService;
import com.sdh.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
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
    @PostMapping(value = "addGoods",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String addGoods(Goods goods, HttpSession session){
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
            String images = session.getServletContext().getRealPath("/images");
//            System.out.println(images);
//            goods.getPic().transferTo(new File("E:/MyStudy/IDEA-WorkSpace/ThreeLevel/TTSX_Back_MavenWeb_Project/src/main/webapp/images/"+goods.getPicture()));
            goods.getPic().transferTo(new File(images+"/"+goods.getPicture()));
            goodsService.addGoods(goods);
//            return URLEncoder.encode(goods.getPicture(),"utf-8");
            return goods.getPicture();
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

    @PostMapping(value = "updateGoods",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String updateGoods(Goods goods,HttpSession session){
        try {
            String filename = goods.getPic().getOriginalFilename();
            if (!StringUtils.isEmpty(filename)) {
                /* 获取上传的文件类型，判断是否是图片 */
                String contentType = goods.getPic().getContentType();
                String[] fileType = contentType.split("/");
                if(!"image".equals(fileType[0])){
                    return "3";
                }
                /* 获取唯一文件名，为了防止文件重名 */
                String str = UUID.randomUUID().toString();
                String filename1 = "goods/"+str+"_"+filename;
                String realPath = session.getServletContext().getRealPath("/images");
                goods.getPic().transferTo(new File(realPath+"/"+filename1));
                /* 数据库存储路径 */
                goods.setPicture(filename1);
            }
            goodsService.updateGoodsById(goods);
            return "1";
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
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
