package cn.zpro.spring.springevent.event;

import java.time.Clock;

/**
 * 类的描述
 *
 * @author guolong.zhang
 * @date 2022/04/19 10:13
 **/
public class UserExtEvent extends UserEvent {

    public UserExtEvent(Object source) {
        super(source);
    }

    public UserExtEvent(Object source, Clock clock) {
        super(source, clock);
    }
}
