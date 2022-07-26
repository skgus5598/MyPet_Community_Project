package com.rainaq.mypet.common.imgFiles;

import com.rainaq.mypet.newStory.entity.MainBoard;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class FileService {
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

       // mapper.insertBoard(dto);
    }
}
