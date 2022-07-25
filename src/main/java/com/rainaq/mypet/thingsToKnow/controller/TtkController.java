package com.rainaq.mypet.thingsToKnow.controller;

import com.rainaq.mypet.boardCategory.BoardCategory;
import com.rainaq.mypet.boardCategory.CategoryRepo;
import com.rainaq.mypet.thingsToKnow.entity.TtkBoard;
import com.rainaq.mypet.thingsToKnow.service.TtkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("ttk")
public class TtkController {

    @Autowired
    TtkServiceImpl tService;

    @Autowired
    CategoryRepo categoryRepo;

    @GetMapping("ttkMain")
    public String ttkMain(){
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
    public String insertForm(TtkBoard dto){
        System.out.println("dto ? " + dto.toString());
        tService.insertForm(dto);
        return "redirect:/ttkMain";
    }

}
