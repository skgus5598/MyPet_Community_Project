package com.rainaq.mypet.newStory.controller;

import com.rainaq.mypet.newStory.entity.MainBoard;
import com.rainaq.mypet.newStory.service.MainServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("newStory")
public class MainController {

    @Autowired
    MainServiceImpl mainService;

    @GetMapping("main")
    public String mainPage(Model model){
        mainService.getList(model);
        return "index";

    }

    @GetMapping("addForm")
    public String main_addForm(){
        return "newStory/mainAddForm";
    }

    @PostMapping("insertForm")
    public String main_insertForm(@RequestParam("files") List<MultipartFile> files, MainBoard dto){
        mainService.insertBoard(files, dto);
        return "redirect:main";
    }



    @DeleteMapping(value = "deleteBoard", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String deleteboard(@RequestParam int boardId, @RequestParam String imgName ){
        return mainService.deleteBoard(boardId, imgName);
    }


}
