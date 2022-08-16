package com.rainaq.mypet.newStory.repository;

import com.rainaq.mypet.newStory.entity.MainBoard;
import com.rainaq.mypet.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MainRepository extends JpaRepository<MainBoard,Integer> {

    MainBoard findByBoardId(int boardId);
    List<MainBoard> findAllBy();
    int deleteByBoardId(int boardId);

    List<MainBoard> findAllByUser(UserEntity user);
}
