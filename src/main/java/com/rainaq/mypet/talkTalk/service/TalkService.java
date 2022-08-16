package com.rainaq.mypet.talkTalk.service;

import com.rainaq.mypet.talkTalk.entity.TalkBoard;
import com.rainaq.mypet.thingsToKnow.entity.TtkBoard;
import com.rainaq.mypet.user.entity.UserEntity;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface TalkService {

    public void insertForm(TalkBoard dto);
    public void getAllList(Model model);
    public void boardDetail(Model model, int boardId);

    List<TalkBoard> getMyTalkList(String userId);
}
