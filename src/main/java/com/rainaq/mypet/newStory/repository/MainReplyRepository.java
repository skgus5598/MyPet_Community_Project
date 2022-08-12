package com.rainaq.mypet.newStory.repository;

import com.rainaq.mypet.newStory.entity.MainBoard;
import com.rainaq.mypet.newStory.entity.MainReply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MainReplyRepository extends JpaRepository<MainReply, Integer> {

    List<MainReply> findAllByBoard(MainBoard board);
}
