package cn.zpro.spring.springevent.exception;

import org.springframework.util.ErrorHandler;

/**
 * @author zhangguolong
 */
public class MyErrorHandler implements ErrorHandler {

    @Override
    public void handleError(Throwable throwable) {  
        System.out.println("事件失败了, error message : " + throwable.getMessage());

    }

} 