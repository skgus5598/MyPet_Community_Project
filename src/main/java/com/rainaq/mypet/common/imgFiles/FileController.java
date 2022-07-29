package com.rainaq.mypet.common.imgFiles;

import com.rainaq.mypet.myPage.entity.Trudy;
import com.rainaq.mypet.newStory.entity.MainBoard;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("files")
public class FileController {
    @GetMapping("download")
    public void download(@RequestParam("files") String dbFileName, HttpServletResponse response)throws Exception{
        //    response.addHeader("Content-disposition", "attachment;filenAME="+dbFileName);
        String[] imgName = dbFileName.split("//");
        System.out.println("imgName ? " + Arrays.toString(imgName));
        for(String img :imgName){
//            File file = new File("/Users/raina/Desktop/mppImg/"+img);
            File file = new File("C:/Users/inosoft-5/Desktop/MyPet_Community_Project/board_image/"+img);

            System.out.println(file.getName());

            FileInputStream fis = new FileInputStream(file);
            FileCopyUtils.copy(fis, response.getOutputStream());
            fis.close();
        }
    }






}
