package com.sean.dianping.controller;

import com.sean.dianping.bean.User;
import com.sean.dianping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author sean
 * @since 2020-01-26
 */
@Controller
@RequestMapping("/user")
public class UserController {

    public static final String CURRENT_USER_SESSION = "currentUserSession";

    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return "test";
    }


    @RequestMapping("/get")
    @ResponseBody
    public User getUser(@RequestParam(name = "id") Integer id) {
        return userService.getById(id);
    }
}

