package cn.edu.zjut.csma.label.service.impl;

import cn.edu.zjut.csma.label.entity.NewsInfo;
import cn.edu.zjut.csma.label.mapper.NewsInfoMapper;
import cn.edu.zjut.csma.label.service.NewsInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


@Service
public class NewsInfoServiceImpl extends ServiceImpl<NewsInfoMapper, NewsInfo> implements NewsInfoService {

    //根据课程id查询课程基本信息
    @Override
    public NewsInfo getNewsInfo(String newsId) {
        NewsInfo newsInfo = baseMapper.selectById(newsId);
        System.out.println(newsInfo);
        return newsInfo;
    }

}
