package cn.zpro.spring.springevent.thread;

import cn.hutool.core.thread.ThreadUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 类的描述
 *
 * @author guolong.zhang
 * @date 2022/11/10 14:50
 **/
public class ThreadDemo {
    public static void main(String[] args) {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 10; i++) {
            newFixedThreadPool.execute(() -> {
                String name = Thread.currentThread().getName();
                long id = Thread.currentThread().getId();
                System.out.println(id+":"+name);
            });
        }

    }
}
