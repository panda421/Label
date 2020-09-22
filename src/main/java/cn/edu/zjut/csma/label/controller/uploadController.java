package cn.edu.zjut.csma.label.controller;

import cn.edu.zjut.csma.label.service.CommentInfoService;
import cn.edu.zjut.csma.label.service.FileService;
import cn.edu.zjut.csma.label.service.NewsInfoService;
import cn.edu.zjut.csma.label.service.TaskInfoService;
import cn.edu.zjut.csma.label.service.impl.FileServiceImpl;
import cn.edu.zjut.csma.label.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/labelservice/upload")
@CrossOrigin
public class uploadController {
    @Autowired
    NewsInfoService newsInfoService;
    @Autowired
    CommentInfoService commentInfoService;
    @Autowired
    TaskInfoService taskInfoService;
    @Autowired
    private FileServiceImpl fileService;

//    @PostMapping("/uploadone")
//    public R uploadNewsFile(HttpServletRequest request, @RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2) {
//        if (file1.getSize() == 0 || file2.getSize() == 0) {
//            return R.error();
//        }
//        try {
//            System.err.println("文件是否为空 ： " + file1.isEmpty());
//            System.err.println("文件的大小为 ：" + file1.getSize());
//            System.err.println("文件的媒体类型为 ： " + file1.getContentType());
//            System.err.println("文件的名字： " + file1.getName());
//            System.err.println("文件的originName为： " + file1.getOriginalFilename());
//            System.out.println(ClassUtils.getDefaultClassLoader().getResource("").getPath());
//            String taskId = taskInfoService.uploadTask().getTaskId();
//            System.out.println(taskId);
//
//
//            File newFile1 = new File(ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/" + UUID.randomUUID().toString() + file1.getOriginalFilename());
//            file1.transferTo(newFile1);
//            System.out.println("ppppp" + newFile1.getPath());
//            newsInfoService.uploadNewsInfo(newFile1.getPath(), taskId);
//            newFile1.delete();
//            System.out.println("ppp");
//
//            File newFile2 = new File(ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/" + file2.getOriginalFilename());
//            file2.transferTo(newFile2);
//            System.out.println("qqqq" + newFile2.getPath());
//            commentInfoService.uploadCommentFile(newFile2.getPath(), taskId);
//            newFile2.delete();
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("文件上传失败");
//        }
//        return R.ok();
//    }

    @PostMapping("/bigfile")
    public R uploadbigfile(String name,
                       String md5,
                       Long size,
                       Integer chunks,
                       Integer chunk,
                       MultipartFile file) throws IOException {
        if (chunks != null && chunks != 0) {
            fileService.uploadWithBlock(name, md5,size,chunks,chunk,file);
        } else {
            fileService.upload(name, md5,file);
            System.out.println("qqq");
        }
        return R.ok();
    }


}
