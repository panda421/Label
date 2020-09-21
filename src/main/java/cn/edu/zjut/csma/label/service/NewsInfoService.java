package cn.edu.zjut.csma.label.service;

import cn.edu.zjut.csma.label.entity.NewsInfo;
import com.baomidou.mybatisplus.extension.service.IService;

public interface NewsInfoService extends IService<NewsInfo> {
    void uploadNewsInfo(String filepath,String taskId);

     NewsInfo getNewsInfo();
}
