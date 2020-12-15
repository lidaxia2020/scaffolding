package com.scaffolding.demo.controller;

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

    @RequestMapping("/admin-menu")
    public String adminMenu() {

        return "/admin-menu";
    }

}
