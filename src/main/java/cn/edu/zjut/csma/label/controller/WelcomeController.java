package cn.edu.zjut.csma.label.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/welcome")
@CrossOrigin
public class WelcomeController {
    //添加章节
    @GetMapping("")
    public String addChapter() {
       return "welcome1";
    }
}
