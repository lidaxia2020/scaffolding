package com.scaffolding.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lijiannan
 * @version 1.0
 * @date 2020/12/11 11:30
 */
@Controller
public class HelloController {


    @RequestMapping("/welcome")
    public String welcome() {

        return  "/welcome";
    }

    @RequestMapping("/index")
    public String index() {

        return  "/index";
    }
    @RequestMapping("/member-list")
    public String member_list() {

        return  "/member-list";
    }

}
