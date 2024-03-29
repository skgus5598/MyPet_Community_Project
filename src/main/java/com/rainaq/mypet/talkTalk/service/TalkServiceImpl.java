package com.rainaq.mypet.talkTalk.service;

import com.rainaq.mypet.talkTalk.entity.TalkBoard;
import com.rainaq.mypet.talkTalk.repository.TalkRepository;
import com.rainaq.mypet.thingsToKnow.entity.TtkBoard;
import com.rainaq.mypet.user.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@Slf4j
public class TalkServiceImpl implements TalkService {

    @Autowired
    TalkRepository repo;

    @Override
    public void insertForm(TalkBoard dto) {
        repo.save(dto);
    }

    @Override
    public void getAllList(Model model) {
        List<TalkBoard> list = repo.findAll(Sort.by(Sort.Direction.DESC,"boardId"));
        model.addAttribute("list", list);
    }

    @Override
    public void boardDetail(Model model, int boardId) {
        TalkBoard dto = repo.findByBoardId(boardId);
        model.addAttribute("dto", dto);
    }

    @Override
    public List<TalkBoard> getMyTalkList(String userId) {
        return repo.findAllByUserId(userId);
    }
}
