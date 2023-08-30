import cn.zpro.event.bus.entity.User;
import cn.zpro.event.bus.handler.MyHandler1;
import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 类的描述
 *
 * @author guolong.zhang
 * @date 2022/05/29 17:07
 **/
public class TestGuavaBus {

    @Test
    public void test_sync(){
        User user = new User();
        EventBus eventBus = new EventBus();
        MyHandler1 handler = new MyHandler1();
        eventBus.register(handler);
        eventBus.post(user);
    }

    @Test
    public void test_async(){
        User user = new User();
        AsyncEventBus eventBus = new AsyncEventBus(Executors.newFixedThreadPool(30));
        MyHandler1 handler = new MyHandler1();
        eventBus.register(handler);
        eventBus.post(user);
    }
}
