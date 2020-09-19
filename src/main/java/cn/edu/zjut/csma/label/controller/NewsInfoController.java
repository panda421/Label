package cn.edu.zjut.csma.label.controller;


import cn.edu.zjut.csma.label.entity.NewsInfo;
import cn.edu.zjut.csma.label.service.NewsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/labelservice/newsInfo")
@CrossOrigin
public class NewsInfoController {
    @Autowired
    private NewsInfoService newsInfoService;

    //添加章节
    @GetMapping("getNewsInfo")
    public String getNewsInfo(){
        NewsInfo newsInfo=newsInfoService.getNewsInfo();
        return newsInfo.toString();
    }
}
