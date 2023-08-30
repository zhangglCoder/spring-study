package cn.zpro.spring.springevent.handler;

import cn.zpro.spring.springevent.config.MyConfig;
import cn.zpro.spring.springevent.entity.User;
import cn.zpro.spring.springevent.event.MyEventListener;
import cn.zpro.spring.springevent.event.UserExtEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;


/**
 * 注解监听
 *
 * @author guolong.zhang
 * @date 2022/04/14 15:26
 **/
@Component
@Slf4j
public class MyHandler2 {

    @MyEventListener(name = "user:add:action")
    public void registerSendMsg(UserExtEvent userEvent) {
        User source = (User) userEvent.getSource();
        //System.out.println("异步:"+Thread.currentThread().getName()+ ":userHandler2-收到消息:"+source);
        System.out.println("MyEventListener"+source);
    }

}
