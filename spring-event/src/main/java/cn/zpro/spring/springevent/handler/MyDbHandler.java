package cn.zpro.spring.springevent.handler;

import cn.zpro.spring.springevent.entity.User;
import cn.zpro.spring.springevent.event.UserExtEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * 事务监听
 *
 * @author guolong.zhang
 * @date 2022/06/15 19:01
 **/
@Component
public class MyDbHandler {

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void dbHandler(User user) {
        System.out.println("事务事件处理:"+Thread.currentThread().getName()+ ":dbHandler-收到消息:"+user);
    }

}
