package cn.zpro.spring.springevent.handler;

import cn.zpro.spring.springevent.entity.User;
import cn.zpro.spring.springevent.event.MyEventListener;
import cn.zpro.spring.springevent.event.UserExtEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


/**
 * 注解监听
 *
 * @author guolong.zhang
 * @date 2022/04/14 15:26
 **/
@Component
@Slf4j
public class MyHandler9 {

    @MyEventListener(name = "user:add:action")
    public void registerAccount(UserExtEvent userEvent) {
        User source = (User) userEvent.getSource();
        //System.out.println("异步:"+Thread.currentThread().getName()+ ":userHandler2-收到消息:"+source);
        System.out.println("MyEventListener"+source);
    }

}
