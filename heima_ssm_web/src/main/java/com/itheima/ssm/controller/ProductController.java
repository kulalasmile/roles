package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Product;
import com.itheima.ssm.service.IProductService;
import com.itheima.ssm.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {

        ModelAndView mv = new ModelAndView();
        System.out.println("执行了。。。。。。。。。。。。。");
        List<Product> productList = iProductService.findAll();
        System.out.println(productList);;

        mv.addObject("productList",productList);
        mv.setViewName("product-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Product product){
        System.out.println("执行了+"+product);
        product.setId(UUIDUtils.getUUID());
        iProductService.save(product);
        return "redirect:findAll.do";
    }
}
