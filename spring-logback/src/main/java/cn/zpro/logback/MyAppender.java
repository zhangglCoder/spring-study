package cn.zpro.logback;

import ch.qos.logback.core.UnsynchronizedAppenderBase;

/**
 *
 *
 * @author guolong.zhang
 * @date 2023/08/17 18:43
 **/
public class MyAppender<E> extends UnsynchronizedAppenderBase<E> {

    @Override
    protected void append(Object o) {

    }
}
