package cn.edu.zjut.csma.label;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"cn.edu.zjut.csma.label"})
@MapperScan("cn.edu.zjut.csma.label.mapper")
public class LabelApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabelApplication.class, args);
    }

}
