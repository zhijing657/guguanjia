package cn.zhijing.controller;

import cn.zhijing.entity.User;
import cn.zhijing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController1 {
    @Autowired
    UserService service;

    @RequestMapping("list")
    @ResponseBody
    public List<User> list(){
        return service.findAll();
    }
}
