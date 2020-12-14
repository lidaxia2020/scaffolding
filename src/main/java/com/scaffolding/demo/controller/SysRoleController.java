package com.scaffolding.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/12/12 16:27
 */
@Controller
@RequestMapping("/sysRole")
public class SysRoleController {


    @RequestMapping("/admin-role")
    public String adminRole() {

        return "/admin-role";
    }

    @RequestMapping("/role-add")
    public String roleAdd() {

        return "/role-add";
    }

}
