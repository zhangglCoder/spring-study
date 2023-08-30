package cn.zpro.spring.springevent.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.RequestHandledEvent;

/**
 * spring 启动监听器
 *
 * @author guolong.zhang
 * @date 2022/04/14 15:39
 **/
@Component
public class MyContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println(event);
    }

}
