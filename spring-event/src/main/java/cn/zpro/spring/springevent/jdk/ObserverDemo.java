package cn.zpro.spring.springevent.jdk;

import cn.zpro.spring.springevent.event.JdkEvent;

import java.util.EventListener;
import java.util.Observable;
import java.util.Observer;

/**
 * 发布订阅模式
 *
 * @author guolong.zhang
 * @date 2022/05/05 19:15
 **/
public class ObserverDemo {

    public static void main(String[] args) {

        EventObservable observable = new EventObservable();

        // 添加观察者（监听者）
        observable.addObserver(new EventObserver());
        observable.addObserver(new EventObserver());

        // 发布消息（事件）
        observable.notifyObservers("Hello,World");

    }

    static class EventObservable extends Observable {
        @Override
        public void setChanged() {
            super.setChanged();
        }

        public void notifyObservers(String arg) {
            this.setChanged();
            super.notifyObservers(new JdkEvent(arg));
            clearChanged();
        }
    }

    static class EventObserver implements Observer, EventListener {

        @Override
        public void update(Observable o, Object event) {
            JdkEvent eventObject = (JdkEvent) event;
            System.out.println("收到事件 ：" + eventObject);
        }
    }

}
