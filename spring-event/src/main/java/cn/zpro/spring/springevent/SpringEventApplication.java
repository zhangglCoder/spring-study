package cn.zpro.spring.springevent;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author zhangguolong
 */
@SpringBootApplication
@EnableAsync
@MapperScan("cn.zpro.spring.springevent.mapper")
@EnableTransactionManagement
public class SpringEventApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringEventApplication.class, args);
    }

}
