package cn.redission.test;

/**
 *
 * @author guolong.zhang
 * @date 2023/07/24 11:02
 **/
public class TestListener implements RedisDelayedQueueListener {

    public void invoke(Object o) {
        System.out.println("监听了");
    }
}
