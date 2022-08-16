package com.rainaq.mypet.thingsToKnow.service;

import com.rainaq.mypet.common.boardCategory.BoardCategory;
import com.rainaq.mypet.thingsToKnow.entity.TtkBoard;
import com.rainaq.mypet.user.entity.UserEntity;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface TtkService {

    public void insertForm(MultipartFile file, TtkBoard dto);
    public List<TtkBoard> getAllList();

    public void boardDetail(Model model, int boardId);

    List<TtkBoard> getMenuList(BoardCategory categoryId);

    String deleteBoard(int boardId, String imgName);

    List<TtkBoard> getMyTtkList(UserEntity user);
}
