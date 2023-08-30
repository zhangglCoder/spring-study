package cn.zpro.spring.springevent.listener;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 请求监听器
 *
 * @author guolong.zhang
 * @date 2022/04/14 15:39
 **/
@Component
public class MyRequestListener {

    @EventListener
    public void test(ContextRefreshedEvent event){
        System.out.println("test:"+event);
    }
}
