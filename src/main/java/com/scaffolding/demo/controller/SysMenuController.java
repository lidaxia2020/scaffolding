package com.scaffolding.demo.controller;

import com.scaffolding.demo.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lijiannan
 * @version 1.0
 * @date 2020/12/15 16:10
 */
@Controller
@RequestMapping("/sysMenu")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;


    @RequestMapping("/admin-menu")
    public String adminMenu() {

        return "/admin-menu";
    }

}
