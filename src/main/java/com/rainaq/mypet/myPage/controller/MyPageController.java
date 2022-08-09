package com.rainaq.mypet.myPage.controller;

import com.rainaq.mypet.myPage.entity.Trudy;
import com.rainaq.mypet.myPage.service.MyPageServiceImpl;
import com.rainaq.mypet.user.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("myPage")
public class MyPageController {

    @Autowired
    MyPageServiceImpl mpService;

    @GetMapping("myHome")
    public String myHome(){
        return "myPage/myPage_main";
    }

    @GetMapping("myTrudy")
    public String myTrudy(){
        return "myPage/myPage_trudy";
    }

    @GetMapping("getTrudyList")
    @ResponseBody
    public List<Trudy> getTrudyList(HttpSession session){
        String str = (String)session.getAttribute("userId");
        UserEntity user = new UserEntity();
        user.setUserId(str);
        return mpService.getList(user);

    }

    @DeleteMapping(value = "deleteTrudy", produces = "application/json;charset=utf-8")
    @ResponseBody
    public void deleteTrudy(@RequestParam int trudyId, @RequestParam String imgName){
        mpService.delTrudy(trudyId, imgName);
    }


    @PostMapping("insertForm")
    @ResponseBody
    public void addTrudyForm(@RequestParam("file") MultipartFile file, Trudy dto ){
        mpService.insertForm(file, dto);

    }


}
