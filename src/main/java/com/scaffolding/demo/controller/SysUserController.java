package com.scaffolding.demo.controller;

import com.scaffolding.demo.entity.SysUser;
import com.scaffolding.demo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/12/12 20:43
 */
@Controller
@RequestMapping("/sysUser")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("/admin-list")
    public ModelAndView adminList(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int pageSize,
                                   @RequestParam(required = false) String username,
                                   @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") @RequestParam(required = false)   LocalDateTime startTime,
                                   @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") @RequestParam(required = false)   LocalDateTime endTime) {
        ModelAndView modelAndView = new ModelAndView();
        Map data = sysUserService.list(page, pageSize,
                username, startTime,
                endTime);
        modelAndView.addObject("data", data);
        modelAndView.setViewName("/admin-list");
        return modelAndView;
    }

    @RequestMapping("/add")
    @ResponseBody
    public void add(@RequestBody SysUser sysUser){

        sysUserService.add(sysUser);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public void delete(@RequestBody List<Integer> ids){

        sysUserService.delete(ids);
    }
}
