package cn.edu.zjut.csma.label;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.edu.zjut.csma.label.mapper")
public class LabelApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabelApplication.class, args);
    }

}
