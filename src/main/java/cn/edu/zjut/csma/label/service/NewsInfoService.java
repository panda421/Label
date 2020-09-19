package cn.edu.zjut.csma.label.service;

import cn.edu.zjut.csma.label.entity.NewsInfo;
import com.baomidou.mybatisplus.extension.service.IService;

public interface NewsInfoService extends IService<NewsInfo> {
    public NewsInfo getNewsInfo();
}
