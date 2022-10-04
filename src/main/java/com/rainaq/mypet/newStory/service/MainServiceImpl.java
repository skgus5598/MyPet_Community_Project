package com.rainaq.mypet.newStory.service;

import com.rainaq.mypet.common.imgFiles.FileService;
import com.rainaq.mypet.newStory.entity.MainBoard;
import com.rainaq.mypet.newStory.entity.MainReply;
import com.rainaq.mypet.newStory.mapper.MainMapper;
import com.rainaq.mypet.newStory.repository.MainReplyRepository;
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
    private final MainReplyRepository replyRepo;

    private final MainMapper mapper;

    private final FileService fileService;

    public void getList(Model model){
        List<MainBoard> list = repository.findAll(Sort.by(Sort.Direction.DESC,"boardId"));


        // list 찍어보기



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

    @Override
    public void addReply(MainReply dto) {
        replyRepo.save(dto);
    }

    @Override
    public List<MainReply> getReplyList(MainBoard board) {
        List<MainReply> list = replyRepo.findAllByBoard(board);
        list.forEach(s -> System.out.println(s.getBoard().getBoardId()));
        System.out.println("list :: " +list.toString());
        return replyRepo.findAllByBoard(board);
    }

    @Override
    public void getStoryDetail(int boardId, Model model) {
        MainBoard dto = repository.findByBoardId(boardId);
        model.addAttribute("dto" , dto);
        System.out.println("dto : " + dto.getUser());
    }


}
