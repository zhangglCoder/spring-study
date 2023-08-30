package cn.zpro.spring.springevent.handler;

import cn.zpro.spring.springevent.event.UserEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * spring-api 方式监听
 *
 * @author guolong.zhang
 * @date 2022/05/15 10:34
 **/
//@Component
//public class MyApiMonitor implements ApplicationListener<UserEvent> {
//
//    @Override
//    public void onApplicationEvent(UserEvent event) {
//        System.out.println("同步:"+Thread.currentThread().getName()+ ":MyHandlerAPi-收到消息:"+event);
//    }
//}
