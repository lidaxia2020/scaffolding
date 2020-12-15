package com.scaffolding.demo.controller;

import com.scaffolding.demo.dto.SysUserDto;
import com.scaffolding.demo.entity.SysUser;
import com.scaffolding.demo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView adminList(@ModelAttribute SysUserDto sysUserDto) {
        ModelAndView modelAndView = new ModelAndView();
        Map data = sysUserService.list(sysUserDto.getPage(), sysUserDto.getSize(),
                sysUserDto.getUsername(), sysUserDto.getStartTime(),
                sysUserDto.getEndTime());
        modelAndView.addObject("data", data);
        modelAndView.addObject("sysUserDto", sysUserDto);
        modelAndView.setViewName("/admin-list");
        return modelAndView;
    }

    @RequestMapping("/list")
    public Object list(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int pageSize,
                                  @RequestParam(required = false) String username,
                                  @RequestParam(required = false) String startTime,
                                  @RequestParam(required = false) String endTime) {
        return sysUserService.list(page, pageSize,
                username, startTime,
                endTime);
    }

    @RequestMapping("/admin-add")
    public String admin_add() {

        return "/admin-add";
    }

    @RequestMapping("/admin-edit/{id}")
    public ModelAndView admin_edit(@PathVariable Integer id) {
        SysUser sysUser = sysUserService.getById(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("sysUser", sysUser);
        modelAndView.setViewName("/admin-edit");
        return modelAndView;
    }


    @RequestMapping("/add")
    @ResponseBody
    public void add(@RequestBody SysUser sysUser) {

        sysUserService.save(sysUser);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public void delete(@RequestBody List<Integer> ids) {

        sysUserService.removeByIds(ids);
    }
}
