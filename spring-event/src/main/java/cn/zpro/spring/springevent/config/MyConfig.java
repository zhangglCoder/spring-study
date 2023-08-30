package cn.zpro.spring.springevent.config;

import cn.zpro.spring.springevent.exception.MyErrorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 类的描述
 *
 * @author guolong.zhang
 * @date 2022/05/07 13:59
 **/
@Configuration
public class MyConfig {

    @Autowired
    private SimpleApplicationEventMulticaster simpleApplicationEventMulticaster;

    @Bean
    public SimpleApplicationEventMulticaster simpleApplicationEventMulticaster(){
        simpleApplicationEventMulticaster.setErrorHandler(new MyErrorHandler());
//        simpleApplicationEventMulticaster.setTaskExecutor(threadPoolExecutor());
        return simpleApplicationEventMulticaster;
    }

    @Bean
    public Executor threadPoolExecutor(){
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(3);
        threadPoolTaskExecutor.setMaxPoolSize(5);
        return threadPoolTaskExecutor;
    }

}
