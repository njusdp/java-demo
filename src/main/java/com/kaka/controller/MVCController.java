package com.kaka.controller;

import com.kaka.model.User;
import com.kaka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by sundaoping on 2018/6/10.
 */

@Controller
@RequestMapping("/mvc")
public class MVCController {


    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    public String hello(){
        return "mvc/hello";
    }



}
