package com.rainaq.mypet.trudies.repository;

import com.rainaq.mypet.trudies.entity.MainBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface MainRepository extends JpaRepository<MainBoard,Integer> {

    MainBoard findByBoardId(int boardId);
    List<MainBoard> findAll();
    int deleteByBoardId(int boardId);
}
