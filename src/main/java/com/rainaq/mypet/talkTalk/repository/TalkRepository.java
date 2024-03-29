package com.rainaq.mypet.talkTalk.repository;

import com.rainaq.mypet.talkTalk.entity.TalkBoard;
import com.rainaq.mypet.thingsToKnow.entity.TtkBoard;
import com.rainaq.mypet.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TalkRepository extends JpaRepository<TalkBoard, Integer> {

    List<TalkBoard> findAll();

    TalkBoard findByBoardId(int boardId);

    List<TalkBoard> findAllByUserId(String userId);


}
