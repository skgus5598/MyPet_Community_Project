package com.rainaq.mypet.thingsToKnow.service;

import com.rainaq.mypet.thingsToKnow.entity.TtkBoard;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

public interface TtkService {

    public void insertForm(MultipartFile file, TtkBoard dto);
    public void getList(Model model);
}
