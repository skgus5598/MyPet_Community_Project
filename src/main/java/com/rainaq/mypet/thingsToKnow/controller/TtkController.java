package com.rainaq.mypet.thingsToKnow.controller;

import com.rainaq.mypet.common.boardCategory.CategoryRepo;
import com.rainaq.mypet.thingsToKnow.entity.TtkBoard;
import com.rainaq.mypet.thingsToKnow.service.TtkServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("ttk")
public class TtkController {

    @Autowired
    TtkServiceImpl tService;

    @Autowired
    CategoryRepo categoryRepo;

    @GetMapping("ttkMain")
    public String ttkMain(Model model){
        tService.getList(model);
        return "thingsToKnow/ttkMain";
    }

    @GetMapping("addForm")
    public String addForm(){
        return "thingsToKnow/ttkAddForm";
    }

    @GetMapping(value = "getCategory", produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<String> getCategory(Model model){
        List<String> cateList = categoryRepo.getCategoryList();
        return cateList;
    }

    @PostMapping("insertForm")
    public String insertForm(@RequestParam("file") MultipartFile file, TtkBoard dto){
        tService.insertForm(file,dto);
        return "redirect:/ttk/ttkMain";
    }

}
