package com.rainaq.mypet.newStory.service;

import com.rainaq.mypet.newStory.entity.MainBoard;
import com.rainaq.mypet.newStory.entity.MainReply;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MainService {

    public void getList(Model model);
    public void insertBoard(List<MultipartFile> files, MainBoard dto);
    public String deleteBoard(int boardId, String imgName);

    void addReply(MainReply dto);

    List<MainReply> getReplyList(MainBoard board);

    void getStoryDetail(int boardId, Model model);
}
