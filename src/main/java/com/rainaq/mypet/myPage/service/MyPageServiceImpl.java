package com.rainaq.mypet.myPage.service;

import com.rainaq.mypet.myPage.entity.Trudy;
import com.rainaq.mypet.myPage.repository.MyPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class MyPageServiceImpl implements MyPageService{

    @Autowired
    MyPageRepository repo;


    @Override
    public void insertForm(MultipartFile file, Trudy dto) {

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss-");
        String current_date = now.format(formatter);
        String dbFileName = "";

        String filename = current_date+file.getOriginalFilename();
        try{
    //      file.transferTo(new File("/Users/raina/Desktop/mppImg/" + filename));
            file.transferTo(new File("C:/Users/inosoft-5/Desktop/MyPet_Community_Project/board_image/"+ filename));
        }catch (Exception e){
            e.printStackTrace();
        }
        dbFileName += filename;

        dto.setImgName(dbFileName);

        repo.save(dto);
    }

    @Override
    public List<Trudy> getList() {
        return repo.findAll();
    }

    @Override
    public void delTrudy(int trudyId) {
        repo.deleteById(trudyId);
    }
}
