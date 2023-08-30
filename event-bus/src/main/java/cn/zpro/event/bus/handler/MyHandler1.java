package cn.zpro.event.bus.handler;

import cn.zpro.event.bus.entity.User;
import com.google.common.eventbus.Subscribe;

/**
 * 类的描述
 *
 * @author guolong.zhang
 * @date 2022/05/29 17:13
 **/
public class MyHandler1 {

    @Subscribe
    public void invoker(User user){
        String name = Thread.currentThread().getName();
        System.out.println(name+":"+user);
    }
}
