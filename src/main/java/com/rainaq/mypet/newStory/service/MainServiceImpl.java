package com.rainaq.mypet.newStory.service;

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

    public void getList(Model model){
        List<MainBoard> list = repository.findAll(Sort.by(Sort.Direction.DESC,"boardId"));
        model.addAttribute("data" , list);

    }

    @Override
    public void insertBoard(List<MultipartFile> files, MainBoard dto) {

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss-");
        String current_date = now.format(formatter);
        String dbFileName = "";
        try {
            for(int i=0; i<files.size(); i++){
                String filename = current_date+files.get(i).getOriginalFilename();
//                files.get(i).transferTo(new File("/Users/raina/Desktop/mppImg/" + filename));
                files.get(i).transferTo(new File("C:/Users/inosoft-5/Desktop/MyPet_Community_Project/board_image/"+ filename));

                dbFileName += filename + "//"; /*  db저장 시 ' // ' 구분자  */
            }
            System.out.println("dbFilename : " + dbFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        dto.setImgName(dbFileName);

        mapper.insertBoard(dto);
    }

    @Override
    @Transactional
    public String deleteBoard(int boardId, String imgName) {
        deleteImage(imgName);
        int result = repository.deleteByBoardId(boardId);
        if(result == 1){
            return "{\"result\" : true}";
        }else{
            return"{\"result\" : false}";
        }
    }

    private void deleteImage(String imgName){
        String[] imgfileName = imgName.split("//");
        for(String img : imgfileName){
//            File deleteImage = new File("/Users/raina/Desktop/mppImg/"+img);
            File deleteImage = new File("C:/Users/inosoft-5/Desktop/MyPet_Community_Project/board_image/"+img);

            deleteImage.delete();
        }
    }



}
