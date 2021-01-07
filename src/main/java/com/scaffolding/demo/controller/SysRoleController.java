package com.scaffolding.demo.controller;

import com.scaffolding.demo.dto.RoleAddDto;
import com.scaffolding.demo.entity.SysMenu;
import com.scaffolding.demo.entity.SysRole;
import com.scaffolding.demo.result.RestResult;
import com.scaffolding.demo.service.SysMenuService;
import com.scaffolding.demo.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @Autowired
    private SysMenuService sysMenuService;

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
    public ModelAndView roleAdd() {

        List<SysMenu> menusByRoleIds = sysMenuService.getMenus(null);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list", menusByRoleIds);
        modelAndView.setViewName(PREFIX + "/role-add");

        return modelAndView;
    }

    @PostMapping("/save")
    public RestResult roleAdd(@RequestBody RoleAddDto roleAddDto) {

        sysRoleService.roleAdd(roleAddDto);


        return RestResult.suc();
    }

}
