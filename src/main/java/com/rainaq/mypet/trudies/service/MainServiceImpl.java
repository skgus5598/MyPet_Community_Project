package com.rainaq.mypet.trudies.service;

import com.rainaq.mypet.trudies.entity.MainBoard;
import com.rainaq.mypet.trudies.mapper.MainMapper;
import com.rainaq.mypet.trudies.repository.MainRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

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
                files.get(i).transferTo(new File("/Users/raina/Desktop/mppImg/" + filename));
                dbFileName += filename + "//"; /*  db저장 시 ' // ' 구분자  */
            }
            System.out.println("dbFilename : " + dbFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        dto.setImgName(dbFileName);

        mapper.insertBoard(dto);
    }


}
