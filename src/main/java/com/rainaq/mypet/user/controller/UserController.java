package com.rainaq.mypet.user.controller;

import com.rainaq.mypet.user.entity.UserEntity;
import com.rainaq.mypet.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor // 생성자 주입
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @GetMapping(value = "idCheck", produces = "application/json;charset=utf-8")
    @ResponseBody
    public boolean userIdCheck(@RequestParam("userId") String userId){
        return userService.checkId(userId);
    }

    @GetMapping(value = "nickCheck", produces = "application/json;charset=utf-8")
    @ResponseBody
    public boolean userNickCheck(@RequestParam("userNick") String userNick){
        return userService.checkNick(userNick);
    }

    @PostMapping("register")
    public String registerMember(UserEntity dto){
        userService.registerMember(dto);
        return "redirect:/newStory/main";
    }

    @PostMapping(value = "login", produces = "application/json;charset=utf-8")
    @ResponseBody
    public int login(@RequestParam String userId, @RequestParam String userPwd){
        return userService.login(userId, userPwd);
    }

}
