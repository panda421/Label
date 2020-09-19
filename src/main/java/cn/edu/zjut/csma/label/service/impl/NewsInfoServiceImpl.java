package cn.edu.zjut.csma.label.service.impl;

import cn.edu.zjut.csma.label.entity.NewsInfo;
import cn.edu.zjut.csma.label.mapper.NewsInfoMapper;
import cn.edu.zjut.csma.label.service.NewsInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class NewsInfoServiceImpl extends ServiceImpl<NewsInfoMapper, NewsInfo> implements NewsInfoService {

    //根据课程id查询课程基本信息
    @Override
    public NewsInfo getNewsInfo() {
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("news_id","324355");
        NewsInfo newsInfo=baseMapper.selectOne(wrapper);
        System.out.println(newsInfo);
        return newsInfo;
    }

}
