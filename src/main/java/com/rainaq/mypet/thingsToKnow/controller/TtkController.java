package com.rainaq.mypet.thingsToKnow.controller;

import com.rainaq.mypet.common.boardCategory.BoardCategory;
import com.rainaq.mypet.common.boardCategory.CategoryRepo;
import com.rainaq.mypet.thingsToKnow.entity.TtkBoard;
import com.rainaq.mypet.thingsToKnow.service.TtkServiceImpl;
import com.rainaq.mypet.user.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
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
    public String ttkMainPage(){
        return "thingsToKnow/ttkMain";
    }
    @GetMapping(value = "ttkAllList", produces = "application/json;charset=utf-8")
    @ResponseBody
    public  List<TtkBoard> ttkAllList(){
        return  tService.getAllList();
    }

    @GetMapping(value = "getMenuList", produces = "application/json;charset=utf-8")
    @ResponseBody
    public  List<TtkBoard> getMenuList(@RequestParam("num") BoardCategory category){
        return  tService.getMenuList(category);
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

    @GetMapping("boardDetail")
    public String boardDetail(@RequestParam("boardId") int boardId, Model model){
        tService.boardDetail(model, boardId);
        return "/thingsToKnow/ttkDetail";
    }

    @DeleteMapping(value = "deleteBoard", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String deleteBoard(@RequestParam int boardId, @RequestParam String imgName ){
        return tService.deleteBoard(boardId, imgName);
    }

    @GetMapping("getMyTtkList")
    @ResponseBody
    public List<TtkBoard> getMyTtkList(HttpSession session){
        String str = (String)session.getAttribute("userId");
        UserEntity user = new UserEntity();
        user.setUserId(str);
        return tService.getMyTtkList(user);
    }




}
