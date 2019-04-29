package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.IRoleService;
import com.itheima.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired IUserService userService;
    @Autowired IRoleService roleService;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {

        List<UserInfo> users = userService.findAll();

        ModelAndView mv = new ModelAndView();
        mv.addObject("userList",users);
        mv.setViewName("user-list");
        return mv;
    }
    @RequestMapping("/save.do")
    public String save(UserInfo user) throws Exception{
        userService.save(user);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam(name = "id",required = true) String id) throws Exception {
        UserInfo user =  userService.findById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("user",user);
        mv.setViewName("user-show");
        return mv;
    }

    @RequestMapping("findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id",required = true) String id) throws Exception{
        UserInfo user = userService.findById(id);
        List<Role> roleList = roleService.findOtherRole(id);

        ModelAndView mv = new ModelAndView();
        mv.addObject("user",user);
        mv.addObject("roleList",roleList);
        mv.setViewName("user-role-add");
        return mv;
    }

    @RequestMapping("addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId",required = true)String userId,@RequestParam(name = "ids",required = true) String[] roleIds) throws Exception {
        userService.addRoleToUser(userId,roleIds);
        return "redirect:findAll.do";
    }
}
