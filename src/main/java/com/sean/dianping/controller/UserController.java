package com.sean.dianping.controller;

import com.sean.dianping.bean.UserModel;
import com.sean.dianping.common.BusinessException;
import com.sean.dianping.common.CommonRes;
import com.sean.dianping.common.CommonUtil;
import com.sean.dianping.common.EmBusinessError;
import com.sean.dianping.request.LoginReq;
import com.sean.dianping.request.RegisterReq;
import com.sean.dianping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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
    private HttpServletRequest httpServletRequest;

    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return "test";
    }

    @RequestMapping("/get")
    @ResponseBody
    public CommonRes getUser(@RequestParam(name = "id") Integer id) throws BusinessException {
        UserModel userModel = userService.getById(id);
        if (userModel == null) {
            throw new BusinessException(EmBusinessError.NO_OBJECT_FOUND);
        } else {
            return CommonRes.create(userModel);
        }
    }

    @RequestMapping("/index")
    public ModelAndView index() {
        String userName = "sean";
        ModelAndView modelAndView = new ModelAndView("/index.html");
        modelAndView.addObject("name", userName);
        return modelAndView;
    }

    @RequestMapping("/register")
    @ResponseBody
    public CommonRes register(@Valid @RequestBody RegisterReq registerReq, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, CommonUtil.processErrorString(bindingResult));
            }

            UserModel registerUser = new UserModel();
            registerUser.setTelphone(registerReq.getTelphone());
            registerUser.setPassword(registerReq.getPassword());
            registerUser.setNickName(registerReq.getNickName());
            registerUser.setGender(registerReq.getGender());

            UserModel resUserModel = userService.register(registerUser);
            return CommonRes.create(resUserModel);
        } catch (DuplicateKeyException e) {
            throw new BusinessException(EmBusinessError.REGISTER_DUP_FAIL);
        }
    }

    @RequestMapping("/login")
    @ResponseBody
    public CommonRes login(@RequestBody @Valid LoginReq loginReq, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, CommonUtil.processErrorString(bindingResult));
        }
        UserModel userModel = userService.login(loginReq.getTelphone(), loginReq.getPassword());
        httpServletRequest.getSession().setAttribute(CURRENT_USER_SESSION, userModel);

        return CommonRes.create(userModel);
    }

    @RequestMapping("/logout")
    @ResponseBody
    public CommonRes logout() {
        httpServletRequest.getSession().invalidate();
        return CommonRes.create(null);
    }

    @RequestMapping("/getcurrentuser")
    @ResponseBody
    public CommonRes getCurrentUser() {
        UserModel userModel = (UserModel) httpServletRequest.getSession().getAttribute(CURRENT_USER_SESSION);
        return CommonRes.create(userModel);
    }

}

