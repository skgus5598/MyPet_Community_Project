package com.rainaq.mypet.thingsToKnow.service;

import com.rainaq.mypet.thingsToKnow.entity.TtkBoard;
import com.rainaq.mypet.thingsToKnow.mapper.TtkMapper;
import com.rainaq.mypet.thingsToKnow.repository.TtkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TtkServiceImpl implements TtkService {

    @Autowired
    TtkMapper mapper;

    @Autowired
    TtkRepository repo;


    @Override
    public void insertForm(MultipartFile file, TtkBoard dto) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss-");
        String current_date = now.format(formatter);
        String dbFileName = "";

        String filename = current_date+file.getOriginalFilename();
//      file.transferTo(new File("/Users/raina/Desktop/mppImg/" + filename));
        try{
            file.transferTo(new File("C:/Users/inosoft-5/Desktop/MyPet_Community_Project/board_image/"+ filename));
        }catch (Exception e){
            e.printStackTrace();
        }
        dbFileName += filename;

        System.out.println("dbFilename : " + dbFileName);

        dto.setImgName(dbFileName);
        mapper.insertBoard(dto);
    }

    @Override
    public void getList(Model model) {
        List<TtkBoard> list =  repo.findAll();

        model.addAttribute("data", list);
    }


}
