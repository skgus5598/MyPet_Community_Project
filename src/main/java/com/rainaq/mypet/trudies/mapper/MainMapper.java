package com.rainaq.mypet.trudies.mapper;

import com.rainaq.mypet.trudies.entity.MainBoard;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MainMapper {
    public String getContent();
    public int insertBoard(MainBoard dto);
}
