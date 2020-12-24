package com.scaffolding.demo.controller;

import com.scaffolding.demo.entity.SysRole;
import com.scaffolding.demo.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/12/12 16:27
 */
@Controller
@RequestMapping("/sysRole")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    private static final String PREFIX = "/system/admin";

    @RequestMapping("/admin-role")
    public ModelAndView adminRole() {
        List<SysRole> list = sysRoleService.list();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list", list);
        modelAndView.setViewName(PREFIX + "/admin-role");

        return modelAndView;
    }

    @RequestMapping("/role-add")
    public String roleAdd() {

        return PREFIX + "/role-add";
    }

}
