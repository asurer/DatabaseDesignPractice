package com.situ.springboot.controller;

import com.situ.springboot.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/upload")
public class UpLoadController {
    //Multipartfile封装了所有图片上传信息
    @RequestMapping("/uploadImage")
    @ResponseBody
    public Result uploadImage(MultipartFile file) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        //a.png
        String filename = file.getOriginalFilename();
        String extension = filename.substring(filename.lastIndexOf("."));
        String newFilename = uuid + extension;
        String filePath = "D:\\mypic\\blog\\" + newFilename;
        try {
            file.transferTo(new File(filePath));
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        return Result.ok("上传成功", newFilename);
    }
    public static void main(String[] args) {
        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid);
        System.out.println();
        String str = "a.png";
        int index = str.lastIndexOf(".");
        System.out.println(str.substring(index));

    }
}
