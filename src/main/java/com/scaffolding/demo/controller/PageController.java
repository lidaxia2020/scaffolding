package com.scaffolding.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/12/12 16:27
 */
@Controller
public class PageController {


    @RequestMapping("/welcome")
    public ModelAndView welcome() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("javaRuntimeVersion", System.getProperty("java.runtime.version"));
        modelAndView.addObject("javaVmVendor", System.getProperty("java.vm.vendor"));
        modelAndView.addObject("osName", System.getProperty("os.name"));
        modelAndView.addObject("osVersion", System.getProperty("os.version"));
        modelAndView.addObject("osArch", System.getProperty("os.arch"));
        try {
            InetAddress address = InetAddress.getLocalHost();
            modelAndView.addObject("hostName", address.getHostName());
            modelAndView.addObject("hostAddress", address.getHostAddress());
        } catch (UnknownHostException e) {
            modelAndView.addObject("hostName", "-");
            modelAndView.addObject("hostAddress", "-");
        }
        modelAndView.setViewName("/welcome");
        return modelAndView;
    }

    @RequestMapping("/index")
    public String index() {

        return "/index";
    }

    @RequestMapping("/member-list")
    public String member_list() {

        return "/member-list";
    }



    @RequestMapping("/admin-add")
    public String admin_add() {

        return "/admin-add";
    }

    @RequestMapping("/admin-edit")
    public String admin_edit() {

        return "/admin-edit";
    }


    @RequestMapping("/admin-role")
    public String admin_role() {

        return "/admin-role";
    }

//    @RequestMapping("/error")
//    public String error() {
//
//        return "/error";
//    }



}

