package com.scaffolding.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.scaffolding.demo.entity.SysMenu;
import com.scaffolding.demo.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/12/15 16:10
 */
@Controller
@RequestMapping("/sysMenu")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;

    private static final String PREFIX = "/system/admin";


    @RequestMapping("/admin-menu")
    public ModelAndView adminMenu() {
        ModelAndView modelAndView = new ModelAndView();
        QueryWrapper<SysMenu> queryWrapper = new QueryWrapper();
        queryWrapper.eq("menu_type", "M");
        List<SysMenu> list = sysMenuService.list(queryWrapper);
        modelAndView.addObject("list", list);
        modelAndView.setViewName(PREFIX + "/admin-menu");

        return modelAndView;
    }

}
