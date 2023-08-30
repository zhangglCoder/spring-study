package cn.redission.test;

public interface RedisDelayedQueueListener<T> {

    /**
     * 消费队列
     * @param t 消息泛型
     */
    void invoke(T t);
}