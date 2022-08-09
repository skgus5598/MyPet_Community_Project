package com.rainaq.mypet.myPage.service;

import com.rainaq.mypet.myPage.entity.Trudy;
import com.rainaq.mypet.user.entity.UserEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MyPageService {
    void insertForm(MultipartFile file, Trudy dto);

    List<Trudy> getList(UserEntity userId);

    void delTrudy(int trudyId, String imgName);
}
