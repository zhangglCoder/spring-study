package cn.redission.test;

import cn.redission.dto.UserDto;
import org.redisson.api.RBlockingQueue;

import java.util.concurrent.TimeUnit;

/**
 * 类的描述
 *
 * @author guolong.zhang
 * @date 2023/07/24 11:24
 **/
public class RedisListenerTest {

    public static void main(String[] args) {
        final String queueName = "testQueue";
        RedisTest test = new RedisTest();
        test.getRedissonClient();
        final RBlockingQueue<UserDto> blockingFairQueue = RedisTest.redissonClient.getBlockingQueue(queueName);

        new Thread(new Runnable() {
            public void run() {
                System.out.println("启动监听队列线程:" + queueName);
                while (true) {
                    try {
                        UserDto poll = blockingFairQueue.poll(10, TimeUnit.SECONDS);
                        System.out.println("poll success"+ poll.toString());

                    } catch (Throwable e){
                        try {
                            Thread.sleep(10000);
                        } catch (InterruptedException ex) {
                        }
                    }
                }
            }
        }).start();
    }
}
