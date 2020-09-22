package cn.edu.zjut.csma.label;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@MapperScan("cn.edu.zjut.csma.label.Mapper")
public class LabelApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabelApplication.class, args);
    }

}
