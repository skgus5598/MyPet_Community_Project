package com.rainaq.mypet.myPage.controller;

import com.rainaq.mypet.myPage.entity.Trudy;
import com.rainaq.mypet.myPage.service.MyPageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    public List<Trudy> getTrudyList(){
        return mpService.getList();

    }

    @DeleteMapping(value = "deleteTrudy", produces = "application/json;charset=utf-8")
    @ResponseBody
    public void deleteTrudy(@RequestParam int trudyId, @RequestParam String imgName){
        mpService.delTrudy(trudyId, imgName);
    }


    @PostMapping("insertForm")
    @ResponseBody
    public void addTrudyForm(@RequestParam("file") MultipartFile file, Trudy dto ){
        System.out.println("loginUser ? " + dto.getUserId());
        mpService.insertForm(file, dto);

    }


}
