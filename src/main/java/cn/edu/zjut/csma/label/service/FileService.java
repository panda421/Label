package cn.edu.zjut.csma.label.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
     void upload(String name,
                       String md5,
                       MultipartFile file)throws IOException;

     void uploadWithBlock(String name,
                                String md5,
                                Long size,
                                Integer chunks,
                                Integer chunk,
                                MultipartFile file)throws IOException;

     boolean checkMd5(String md5);
}
