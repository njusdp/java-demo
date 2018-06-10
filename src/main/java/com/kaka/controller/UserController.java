package com.kaka.controller;

import com.baidu.mobileopen.library.json.GsonUtils;
import com.baidu.mobileopen.library.log.Logger;
import com.baidu.mobileopen.library.log.LoggerFactory;
import com.kaka.model.User;
import com.kaka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by sundaoping on 2018/1/2.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);



    @Autowired
    private UserService userService;

    @RequestMapping("/getUser")
    public ModelAndView getUser(String id){
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.getUserById(id);

        logger.info("/user/getUser userInfo").add("name",GsonUtils.toJson(user)).end();



        modelAndView.addObject("user",user);
        modelAndView.setViewName("user/getUser");
        return modelAndView;
    }


}
