package com.rainaq.mypet.common.imgFiles;

import com.rainaq.mypet.myPage.entity.Trudy;
import com.rainaq.mypet.newStory.entity.MainBoard;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class FileService {

    public String insertImgOne(MultipartFile file) {

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss-");
        String current_date = now.format(formatter);
        String dbFileName = "";

        String filename = current_date+file.getOriginalFilename();
        try{
            //      file.transferTo(new File("/Users/raina/Desktop/mppImg/" + filename));
            file.transferTo(new File("C:/Users/inosoft-5/Desktop/MyPet_Community_Project/board_image/"+ filename));
        }catch (Exception e){
            e.printStackTrace();
        }
        dbFileName += filename;

        return dbFileName;
    }

    public String insertImgs(List<MultipartFile> files) {

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
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dbFileName;
    }

    public void deleteImage(String imgName){
        String[] imgfileName = imgName.split("//");
        for(String img : imgfileName){
//            File deleteImage = new File("/Users/raina/Desktop/mppImg/"+img);
            File deleteImage = new File("C:/Users/inosoft-5/Desktop/MyPet_Community_Project/board_image/"+img);

            deleteImage.delete();
        }
    }

}
