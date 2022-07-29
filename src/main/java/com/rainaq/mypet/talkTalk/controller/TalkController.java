package com.rainaq.mypet.talkTalk.controller;

import com.rainaq.mypet.common.imgFiles.FileService;
import com.rainaq.mypet.talkTalk.entity.TalkBoard;
import com.rainaq.mypet.talkTalk.service.TalkServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@Slf4j
@RequestMapping("talk")
public class TalkController {

    @Autowired
    TalkServiceImpl talkService;

    @Autowired
    FileService fileService;

    @GetMapping("talkMain")
    public String talkMain(Model model){
        talkService.getAllList(model);
        return "talkTalk/talkMain";
    }

    @GetMapping("addForm")
    public String addForm(){
        return "talkTalk/talkAddForm";
    }

    @PostMapping("insertForm")
    public String insertForm(@RequestParam(value = "file", required = false) MultipartFile file, TalkBoard dto){ //사진 필수 x
        if(file.getOriginalFilename() == ""){
            dto.setImgName("N");
        }else{
           String imgName = fileService.insertImgOne(file);
            dto.setImgName(imgName);

        }
        talkService.insertForm(dto);
        return "redirect:/talk/talkMain";
    }

    @GetMapping("boardDetail")
    public String boardDetail(@RequestParam int boardId, Model model){
        talkService.boardDetail(model, boardId);
        return "talkTalk/talkDetail";
    }


}
