package cn.edu.zjut.csma.label.service.impl;

import cn.edu.zjut.csma.label.service.CommentInfoService;
import cn.edu.zjut.csma.label.service.NewsInfoService;
import cn.edu.zjut.csma.label.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;

import static cn.edu.zjut.csma.label.utils.FileUtils.generateFileName;
import static cn.edu.zjut.csma.label.utils.UploadUtils.*;

@Service
public class FileServiceImpl {
    @Autowired
    NewsInfoService newsInfoService;
    @Autowired
    CommentInfoService commentInfoService;

    //
    public void upload(String name, String md5, MultipartFile file) throws IOException {
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/" + generateFileName();
        FileUtils.write(path, file.getInputStream());
        if (name.equals("news")) {
            newsInfoService.uploadNewsInfo(path, "123");
        }
        //如果是news，定死输入名字为comment
        if (name.equals("comment")) {
            commentInfoService.uploadCommentFile(path, "123");
        }
        File file1=new File(path);
        file1.delete();
    }

    public void uploadWithBlock(String name, String md5, Long size, Integer chunks, Integer chunk, MultipartFile file) throws IOException {
        String fileName = getFileName(md5, chunks);
        //FileUtils.writeWithBlok(UploadConfig.path + fileName, size, file.getInputStream(), file.getSize(), chunks, chunk);
        //target为文件写入的位置
        String path=ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/" + fileName;
        FileUtils.writeWithBlok(path, size, file.getInputStream(), file.getSize(), chunks, chunk);
        addChunk(md5, chunk);
        //如果所有分块都已上传
        if (isUploaded(md5)) {
            removeKey(md5);
            //将完整的文件逐行写入数据库
            //如果是news文件 定死输入名字为news
            if (name.equals("news")) {
                newsInfoService.uploadNewsInfo(ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/" + fileName, "");
            }
            //如果是news，定死输入名字为comment
            if (name.equals("comment")) {
                commentInfoService.uploadCommentFile(ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/" + fileName, "");
            }
            //读取完成后，删除文件
            File file1=new File(path);
            file1.delete();
        }

    }


//    public boolean checkMd5(String md5) {
//        File file = new File();
//        file.setMd5(md5);
//    }
}
