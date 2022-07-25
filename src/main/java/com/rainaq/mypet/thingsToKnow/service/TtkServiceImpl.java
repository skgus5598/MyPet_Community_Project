package com.rainaq.mypet.thingsToKnow.service;

import com.rainaq.mypet.thingsToKnow.entity.TtkBoard;
import com.rainaq.mypet.thingsToKnow.mapper.TtkMapper;
import com.rainaq.mypet.thingsToKnow.repository.TtkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class TtkServiceImpl implements TtkService {

    @Autowired
    TtkMapper mapper;

    @Autowired
    TtkRepository repo;

    @Override
    public void insertForm(TtkBoard dto) {
        mapper.insertBoard(dto);
    }



}
