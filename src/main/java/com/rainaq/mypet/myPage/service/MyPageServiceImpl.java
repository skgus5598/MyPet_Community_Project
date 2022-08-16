package com.rainaq.mypet.myPage.service;

import com.rainaq.mypet.common.imgFiles.FileService;
import com.rainaq.mypet.myPage.entity.Trudy;
import com.rainaq.mypet.myPage.repository.MyPageRepository;
import com.rainaq.mypet.newStory.entity.MainBoard;
import com.rainaq.mypet.newStory.repository.MainRepository;
import com.rainaq.mypet.user.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MyPageServiceImpl implements MyPageService{

    @Autowired
    MyPageRepository repo;
    @Autowired
    FileService fileService;

    private final MainRepository userRepo;



    @Override
    public void insertForm(MultipartFile file, Trudy dto, HttpSession session) {
        UserEntity user = new UserEntity();
        user.setUserId((String)session.getAttribute("userId"));
        dto.setUser(user);

        String imgName = fileService.insertImgOne(file);
        dto.setImgName(imgName);


        repo.save(dto);
    }

    @Override
    public List<Trudy> getList(UserEntity user) {
        return repo.findAllByUser(user);
    }

    @Override
    public void delTrudy(int trudyId, String imgName) {
        fileService.deleteImage(imgName);
        repo.deleteById(trudyId);
    }

    @Override
    public List<MainBoard> getAllMyStoryList(UserEntity user) {
        return userRepo.findAllByUser(user);
    }

}
