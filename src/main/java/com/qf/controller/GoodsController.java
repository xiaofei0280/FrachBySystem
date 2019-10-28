package com.qf.controller;


import com.qf.pojo.Goods;
import com.qf.service.GoodsService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class GoodsController {


    @Autowired
    private GoodsService goodsService;

      // 添加
    @RequestMapping("/add")
    @RequiresAuthentication
    @RequiresPermissions(value = {"update"})
    public String addgoods(){

        return  "redirect:/add.jsp";
    }



    // 添加商品
    @RequestMapping("/insertgoods")
    @RequiresAuthentication
    public String   insertGoods(MultipartFile source, Goods goods, HttpSession session) throws IOException {
         //  获取文件的原始名称
        String filename = source.getOriginalFilename();
        // 定制全局唯一命名
        String unique = UUID.randomUUID().toString();
         //  定制全局唯一文件名
        String uniqueFilename=unique+filename;

        // 获取磁盘路径
        String realPath = session.getServletContext().getRealPath("/upload");
        // 将上传的文件存入磁盘路径中
        String path=realPath+"/"+uniqueFilename;
        String imgpath="upload"+"/"+uniqueFilename;
        source.transferTo(new File(path));

          goods.setImgpath(imgpath);
          goods.setCreatTime(new Date());

        // 添加商品
           goodsService.addGoods(goods);
         return "index";
    }

   // 查询所有商品列表
   @RequestMapping("/goodslistall")
   @RequiresAuthentication
   @RequiresPermissions(value = {"query","update"},logical = Logical.OR)
   public String getGoodslist(HttpServletRequest request){

       List<Goods> goodslist = goodsService.selectGoodsAll();
       request.setAttribute("goodslist", goodslist);

       return "forward:/goodslist.jsp";
   }


    // 编辑商品

    @RequestMapping("/editgoods")
    @RequiresAuthentication
    @RequiresPermissions(value = {"query","update"},logical = Logical.AND)
    public String editGoods(String id,HttpServletRequest request){
        // 根据id查询商品信息
        Goods goods = goodsService.selectGoodsByid(Integer.parseInt(id));
         request.setAttribute("goods", goods);
        return "forward:/edit.jsp";
    }

    // 修改商品

    @RequestMapping("/updateGoods")
    @RequiresAuthentication
  public String updateGoods(Goods goods, MultipartFile source, HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 通过id 修改商品

        System.out.println(goods);
        System.out.println(source);
        // 获取文件名称
        String fileName = source.getOriginalFilename();
        System.out.println(fileName);
        // 定义全局唯一标识
        String  uuid = UUID.randomUUID().toString();
        // sing一全局唯一文件名
         String uniqueName=uuid+fileName;
        System.out.println(uniqueName);

        // 获取磁盘路径
        String realPath = request.getServletContext().getRealPath("/upload");
        System.out.println(realPath);
        //文件存储路径
        String path=realPath+"/"+uniqueName;
        String imgpath="upload"+"/"+uniqueName;
        System.out.println(imgpath);
        //将上传的文件存储到磁盘中
         source.transferTo(new File(path));
         // 修改
        goods.setImgpath(path);
        goods.setCreatTime(new Date());
        goodsService.updateGoodsById(goods);
        response.getWriter().write(uniqueName);

        return null;
  }


}
