package com.rainaq.mypet.thingsToKnow.repository;

import com.rainaq.mypet.thingsToKnow.entity.TtkBoard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TtkRepository extends JpaRepository<TtkBoard,Integer> {

    List<TtkBoard> findAll();
}
