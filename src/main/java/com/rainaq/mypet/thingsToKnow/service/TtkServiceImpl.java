package com.rainaq.mypet.thingsToKnow.service;

import com.rainaq.mypet.common.boardCategory.BoardCategory;
import com.rainaq.mypet.common.imgFiles.FileService;
import com.rainaq.mypet.thingsToKnow.entity.TtkBoard;
import com.rainaq.mypet.thingsToKnow.mapper.TtkMapper;
import com.rainaq.mypet.thingsToKnow.repository.TtkRepository;
import com.rainaq.mypet.user.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TtkServiceImpl implements TtkService {

    @Autowired
    TtkMapper mapper;
    @Autowired
    TtkRepository repo;

    private final FileService fileService;

    @Override
    public void insertForm(MultipartFile file, TtkBoard dto) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss-");
        String current_date = now.format(formatter);
        String dbFileName = "";

        String filename = current_date+file.getOriginalFilename();
//      file.transferTo(new File("/Users/raina/Desktop/mppImg/" + filename));
        try{
            file.transferTo(new File("C:/Users/inosoft-5/Desktop/MyPet_Community_Project/board_image/"+ filename));
        }catch (Exception e){
            e.printStackTrace();
        }
        dbFileName += filename;

        dto.setImgName(dbFileName);
    //    mapper.insertBoard(dto);
        repo.save(dto);
    }

    @Override
    public List<TtkBoard> getAllList() {
        List<TtkBoard> list =  repo.findAll(Sort.by(Sort.Direction.DESC,"boardId"));
        return list;

    }

    @Override
    public void boardDetail(Model model, int boardId) {
        TtkBoard dto = repo.findByBoardId(boardId);
        model.addAttribute("dto", dto);
    }

    @Override
    public List<TtkBoard> getMenuList(BoardCategory category) {
        return repo.findAllByCategory(category);
    }

    @Override
    @Transactional
    public String deleteBoard(int boardId, String imgName) {
        fileService.deleteImage(imgName);
        int result = repo.deleteByBoardId(boardId);
        if(result == 1){
            return "{\"result\" : true}";
        }else{
            return"{\"result\" : false}";
        }

    }

    @Override
    public List<TtkBoard> getMyTtkList(UserEntity user) {
       return repo.findAllByUser(user);
    }


}
