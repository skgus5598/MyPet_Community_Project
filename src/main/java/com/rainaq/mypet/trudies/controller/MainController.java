package com.rainaq.mypet.trudies.controller;

import com.rainaq.mypet.trudies.entity.MainBoard;
import com.rainaq.mypet.trudies.mapper.MainMapper;
import com.rainaq.mypet.trudies.service.MainServiceImpl;
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
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Controller
@Slf4j
public class MainController {

    @Autowired
    MainServiceImpl mainService;

    @GetMapping("/")
    public String mainPage(Model model){
        mainService.getList(model);
     //   return "index";
        return "index";
    }

    @GetMapping("main/addForm")
    public String main_addForm(){
        return "main/mainAddForm";
    }

    @PostMapping("main/insertForm")
    public String main_insertForm(@RequestParam("files") List<MultipartFile> files, MainBoard dto){
        mainService.insertBoard(files, dto);
        return "redirect:/";
    }

    @GetMapping("main/download")
    public void download(@RequestParam("files") String dbFileName, HttpServletResponse response)throws Exception{
    //    response.addHeader("Content-disposition", "attachment;filenAME="+dbFileName);
        String[] imgName = dbFileName.split("//");
        System.out.println("imgName ? " + Arrays.toString(imgName));
        for(String img :imgName){
            File file = new File("/Users/raina/Desktop/mppImg/"+img);
//            File file = new File("C:/Users/inosoft-5/Desktop/MyPet_Community_Project/board_image/"+img);

            System.out.println(file.getName());

            FileInputStream fis = new FileInputStream(file);
            FileCopyUtils.copy(fis, response.getOutputStream());
            fis.close();
        }
    }

    @DeleteMapping(value = "main/deleteBoard", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String deleteboard(@RequestParam int boardId, @RequestParam String imgName ){
        return mainService.deleteBoard(boardId, imgName);
    }


}
