package com.rainaq.mypet.user.controller;

import com.rainaq.mypet.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor // 생성자 주입
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @PostMapping(value = "idCheck", produces = "application/json;charset=utf-8")
    @ResponseBody
    public boolean userIdCheck(@RequestParam("userId") String userId){
        boolean exist = userService.checkId(userId);
        return exist;
    }

    @PostMapping(value = "nickCheck", produces = "application/json;charset=utf-8")
    @ResponseBody
    public boolean userNickCheck(@RequestParam("userNick") String userNick){
        boolean exist = userService.checkNick(userNick);
        return exist;
    }

}
