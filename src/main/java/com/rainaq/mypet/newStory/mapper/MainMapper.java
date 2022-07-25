package com.rainaq.mypet.newStory.mapper;

import com.rainaq.mypet.newStory.entity.MainBoard;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MainMapper {
    public String getContent();
    public int insertBoard(MainBoard dto);
}
