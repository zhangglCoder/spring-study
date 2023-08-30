package cn.redission.test;
import cn.redission.dto.UserDto;
import org.redisson.Redisson;
import org.redisson.api.RBlockingQueue;
import org.redisson.api.RDelayedQueue;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author guolong.zhang
 * @date 2023/07/24 09:32
 **/
public class RedisTest {

    public static RedissonClient redissonClient;

    public RedissonClient getRedissonClient(){
        if(null != redissonClient){
            return redissonClient;
        }
        Config config = new Config();
        config.useSingleServer().setAddress(String.format("redis://%s:%s", "127.0.0.1", "8143")).setPassword("redis")
                .setDatabase(0)
                .setConnectionPoolSize(128);
        redissonClient = Redisson.create(config);
        return redissonClient;
    }

    public static void main(String[] args) throws InterruptedException {
        RedisTest redisTest = new RedisTest();
        final String queueName = "testQueue";
        redisTest.getRedissonClient();
        final RBlockingQueue<UserDto> blockingFairQueue = RedisTest.redissonClient.getBlockingQueue(queueName);
        RedisTest.redissonClient.getDelayedQueue(blockingFairQueue);

        for (;;){
            TimeUnit.SECONDS.sleep(1);
            push(blockingFairQueue);
        }

        //listen(queueName,blockingFairQueue);
    }

    public static void push(final RBlockingQueue<UserDto> blockingFairQueue){
        UserDto userDto = new UserDto();
        userDto.setName("zgl");
        RDelayedQueue<UserDto> delayedQueue = RedisTest.redissonClient.getDelayedQueue(blockingFairQueue);
        // 时间到了将消息发送到指定队列
        delayedQueue.offer(userDto, 1, TimeUnit.SECONDS);
    }

    public static void listen(final String queueName, final RBlockingQueue<UserDto> blockingFairQueue){
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
