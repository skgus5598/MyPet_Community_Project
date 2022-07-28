package com.rainaq.mypet.myPage.service;

import com.rainaq.mypet.myPage.entity.Trudy;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MyPageService {
    void insertForm(MultipartFile file, Trudy dto);

    List<Trudy> getList();

    void delTrudy(int trudyId);
}
