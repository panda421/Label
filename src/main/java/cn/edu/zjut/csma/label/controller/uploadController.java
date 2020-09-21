package cn.edu.zjut.csma.label.controller;

import cn.edu.zjut.csma.label.entity.TaskInfo;
import cn.edu.zjut.csma.label.service.CommentInfoService;
import cn.edu.zjut.csma.label.service.NewsInfoService;
import cn.edu.zjut.csma.label.service.TaskInfoService;
import cn.edu.zjut.csma.label.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@RestController
@RequestMapping("/labelservice/upload")
public class uploadController {
    @Autowired
    NewsInfoService newsInfoService;
    @Autowired
    CommentInfoService commentInfoService;
    @Autowired
    TaskInfoService taskInfoService;

    @PostMapping("/uploadone")
    public R uploadNewsFile(MultipartFile file1,MultipartFile file2) {
        if (file1.getSize() == 0||file2.getSize() == 0) {
            return R.error();
        }
        try{
            System.err.println("文件是否为空 ： " + file1.isEmpty());
            System.err.println("文件的大小为 ：" + file1.getSize());
            System.err.println("文件的媒体类型为 ： " + file1.getContentType());
            System.err.println("文件的名字： " + file1.getName());
            System.err.println("文件的originName为： " + file1.getOriginalFilename());
            System.out.println(ClassUtils.getDefaultClassLoader().getResource("").getPath());
            String taskId=taskInfoService.uploadTask().getTaskId();
            System.out.println(taskId);
            File newFile1 = new File(ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static/" + UUID.randomUUID().toString()+file1.getOriginalFilename());
            file1.transferTo(newFile1);
            System.out.println("ppppp"+newFile1.getPath());
            newsInfoService.uploadNewsInfo(newFile1.getPath(),taskId);
            newFile1.delete();
            System.out.println("ppp");

            File newFile2 = new File(ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static/" + file2.getOriginalFilename());
            file2.transferTo(newFile2);
            System.out.println("qqqq"+newFile2.getPath());
            commentInfoService.uploadCommentFile(newFile2.getPath(),taskId);
            newFile2.delete();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("文件上传失败");
        }
        return R.ok();
    }



}
