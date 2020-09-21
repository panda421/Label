package cn.edu.zjut.csma.label.service.impl;

import cn.edu.zjut.csma.label.entity.NewsInfo;
import cn.edu.zjut.csma.label.mapper.NewsInfoMapper;
import cn.edu.zjut.csma.label.service.NewsInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;


@Service
public class NewsInfoServiceImpl extends ServiceImpl<NewsInfoMapper, NewsInfo> implements NewsInfoService {
    @Override
    public void uploadNewsInfo(String filepath,String taskId) {
            //BufferedReader是可以按行读取文件
            try{
                FileInputStream inputStream = new FileInputStream(filepath);
                InputStreamReader isr = new InputStreamReader(inputStream, "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(isr);
                //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                String str ;
                while((str = bufferedReader.readLine()) != null)
                {
                    NewsInfo newsInfo=new NewsInfo();
                    JSONObject jsonObj = new JSONObject(str);
                    newsInfo.setContent((String)jsonObj.get("content"));
                    newsInfo.setNewsId((String)jsonObj.get("newsID"));
                    newsInfo.setNewsTitle((String)jsonObj.get("newsTitle"));
                    newsInfo.setTaskId(taskId);
                    System.out.println(newsInfo.getContent());
                    //newsInfo.setTaskId(UUID.randomUUID().toString());
                    baseMapper.insert(newsInfo);
                }

                //close
                inputStream.close();
                bufferedReader.close();
            }catch (Exception e){
                e.printStackTrace();
            }

        }



    //根据课程id查询课程基本信息
    @Override
    public NewsInfo getNewsInfo() {
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("news_id","EN963AHR0001899O");
        NewsInfo newsInfo=baseMapper.selectOne(wrapper);
        System.out.println(newsInfo);
        return newsInfo;
    }

}
