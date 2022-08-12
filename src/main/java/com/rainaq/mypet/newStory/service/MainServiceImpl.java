package com.rainaq.mypet.newStory.service;

import com.rainaq.mypet.common.imgFiles.FileService;
import com.rainaq.mypet.newStory.entity.MainBoard;
import com.rainaq.mypet.newStory.mapper.MainMapper;
import com.rainaq.mypet.newStory.repository.MainRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

@Service
@RequiredArgsConstructor
@Slf4j
public class MainServiceImpl implements MainService {

    private final MainRepository repository; // 의존성주입(@Autowired 대신 private final + 생성자)
    private final MainMapper mapper;

    private final FileService fileService;

    public void getList(Model model){
        List<MainBoard> list = repository.findAll(Sort.by(Sort.Direction.DESC,"boardId"));
        // list 찍어보기

        list.forEach(s ->
                System.out.println("trudy id :: "+ s.getTrudy().getTrudyName() +"//"+s.getUser().getUserId() +"// " + s.getTrudy().getTrudyId())
        );

        model.addAttribute("data" , list);

    }

    @Override
    public void insertBoard(List<MultipartFile> files, MainBoard dto) {

        String imgName = fileService.insertImgs(files);
        dto.setImgName(imgName);
        repository.save(dto);
    //    mapper.insertBoard(dto);
    }

    @Override
    @Transactional
    public String deleteBoard(int boardId, String imgName) {
        fileService.deleteImage(imgName);
        int result = repository.deleteByBoardId(boardId);

        if(result == 1){
            return "{\"result\" : true}";
        }else{
            return"{\"result\" : false}";
        }
    }




}
