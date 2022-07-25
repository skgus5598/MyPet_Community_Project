package com.rainaq.mypet.thingsToKnow.mapper;

import com.rainaq.mypet.thingsToKnow.entity.TtkBoard;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TtkMapper {

    public void insertBoard(TtkBoard dto);

}
