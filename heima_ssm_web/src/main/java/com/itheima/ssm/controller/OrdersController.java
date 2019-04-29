package com.itheima.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private IOrdersService ordersService;
    //未分页
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") int page,@RequestParam(name = "pagesize",required = true,defaultValue = "4") int pagesize) throws Exception {
        List<Orders> ordersList = ordersService.findAll(page,pagesize);
        PageInfo pageInfo = new PageInfo(ordersList);
        System.out.println(ordersList);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("orders-list");
        mv.addObject("ordersList", pageInfo);
        return mv;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true) String ordersId) throws Exception{
        System.out.println("执行了000000000000000000000000000000");
        Orders orders = ordersService.findById(ordersId);
        System.out.println("好了999999999999999999999999999999999");
        System.out.println("执行"+orders+"/n"+orders.getTravellers().toString());
        ModelAndView mv = new ModelAndView();
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return mv;
    }
}
