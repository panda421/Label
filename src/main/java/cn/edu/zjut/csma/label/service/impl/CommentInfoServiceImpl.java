package cn.edu.zjut.csma.label.service.impl;

import cn.edu.zjut.csma.label.entity.CommentInfo;
import cn.edu.zjut.csma.label.mapper.CommentInfoMapper;
import cn.edu.zjut.csma.label.service.CommentInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

@Service
public class CommentInfoServiceImpl extends ServiceImpl<CommentInfoMapper, CommentInfo> implements CommentInfoService {
    @Override
    public void uploadCommentFile(String filepath,String taskId) {
        //BufferedReader是可以按行读取文件
        try{
            FileInputStream inputStream = new FileInputStream(filepath);
            InputStreamReader isr = new InputStreamReader(inputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(isr);
            //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String str ;
            while((str = bufferedReader.readLine()) != null)
            {
                CommentInfo commentInfo=new CommentInfo();
                JSONObject jsonObj = new JSONObject(str);
                commentInfo.setCommentId((String)jsonObj.get("commentID"));
                commentInfo.setContent((String)jsonObj.get("content"));
                commentInfo.setUserId((String)jsonObj.get("userID"));
                commentInfo.setContent((String)jsonObj.get("content"));
                commentInfo.setParentcommentId((String)jsonObj.get("parentCommentID"));
                commentInfo.setNewsId((String)jsonObj.get("newsID"));
                commentInfo.setTaskId(taskId);
                commentInfo.setIsfinished("-1");
                //newsInfo.setTaskId(UUID.randomUUID().toString());
                baseMapper.insert(commentInfo);
            }
            //close
            inputStream.close();
            bufferedReader.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
