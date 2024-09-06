package com.clone.instagram.warmsystargram.domain.UserInfoManagement.controller;


import com.clone.instagram.warmsystargram.domain.UserInfoManagement.dao.User;
import com.clone.instagram.warmsystargram.domain.UserInfoManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;
    //키워드를 포함하는 유저 객체 찾기
    @GetMapping("/")
    public List<User> CheckForUsers(@RequestParam String keyword){
        return userService.findUsersByNickname(keyword);
    }


}
