package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired IPermissionService permissionService;
    @RequestMapping("/findAll.do")
    public ModelAndView findAii() throws Exception {
        List<Permission> permissionList = permissionService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("permissionList",permissionList);
        mv.setViewName("permission-list");
        return mv;
    }


    @RequestMapping("/save.do")
    public String save(Permission permission)throws Exception{
        permissionService.save(permission);
        return "redirect:findAll.do";
    }
}
