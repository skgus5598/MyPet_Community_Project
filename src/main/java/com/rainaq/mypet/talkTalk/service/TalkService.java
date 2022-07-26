package com.rainaq.mypet.talkTalk.service;

import com.rainaq.mypet.talkTalk.entity.TalkBoard;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

public interface TalkService {

    public void insertForm(TalkBoard dto);
    public void getAllList(Model model);
    public void boardDetail(Model model, int boardId);

}
