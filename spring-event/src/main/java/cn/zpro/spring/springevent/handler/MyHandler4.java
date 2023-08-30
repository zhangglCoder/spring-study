package cn.zpro.spring.springevent.handler;

import cn.zpro.spring.springevent.event.JdkEvent;
import cn.zpro.spring.springevent.event.ObjEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 类的描述
 *
 * @author guolong.zhang
 * @date 2022/04/14 15:26
 **/
@Component
@Slf4j
public class MyHandler4 {

    @EventListener(
            classes = {ObjEvent.class,JdkEvent.class},
            condition = "#objEvent.flag == true "
    )
    public void userHandler4(ObjEvent<JdkEvent> objEvent) {
        System.out.println(Thread.currentThread().getName()+"｜"+objEvent.isFlag()+"｜"+objEvent.getOption());
    }

}
