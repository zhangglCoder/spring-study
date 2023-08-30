package cn.zpro.spring.springevent.event;

import org.springframework.context.ApplicationEvent;

import java.time.Clock;

/**
 * 用户事件
 *
 * @author guolong.zhang
 * @date 2022/04/19 10:13
 **/
public class UserEvent extends ApplicationEvent {

    public UserEvent(Object source) {
        super(source);
    }

    public UserEvent(Object source, Clock clock) {
        super(source, clock);
    }
}
