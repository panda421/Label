package cn.edu.zjut.csma.label.service;

import cn.edu.zjut.csma.label.entity.CommentInfo;
import com.baomidou.mybatisplus.extension.service.IService;

public interface CommentInfoService extends IService<CommentInfo> {
    void uploadCommentFile(String filepath,String taskId);
}
