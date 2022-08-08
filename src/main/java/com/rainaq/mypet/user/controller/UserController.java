package com.rainaq.mypet.user.controller;

import com.rainaq.mypet.myPage.entity.Trudy;
import com.rainaq.mypet.user.entity.UserEntity;
import com.rainaq.mypet.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

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
    public int login(@RequestParam String userId, @RequestParam String userPwd,
                     HttpServletRequest request, Model model){
        int result = userService.login(userId,userPwd, model);
        if(result == 1){ // login 성공 시 session 생성
            HttpSession session = request.getSession();
            session.setAttribute("loginUser", model.getAttribute("userNick"));
            session.setAttribute("userId" , userId);
        }
        return result;
    }

    @GetMapping("logout")
    public String logout(HttpSession session){
        //   session.invalidate(); 모든 세션 종료
        session.removeAttribute("loginUser");
        return "redirect:/";
    }

    @GetMapping(value = "userInfo", produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Trudy>  userInfo(HttpSession session){
        Object userId = session.getAttribute("userId");
        List<Trudy> list = userService.getUserInfo((String)userId);
        return list;
    }

}
