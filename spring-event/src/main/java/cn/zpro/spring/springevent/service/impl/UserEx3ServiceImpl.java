package cn.zpro.spring.springevent.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpException;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.zpro.spring.springevent.entity.User;
import cn.zpro.spring.springevent.service.UserEx2Service;
import cn.zpro.spring.springevent.service.UserExService;
import cn.zpro.spring.springevent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 类的描述
 *
 * @author guolong.zhang
 * @date 2022/05/29 13:37
 **/
@Service
public class UserEx3ServiceImpl {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    private UserExService userExService;

    public void save(User user) {
        save3(user);
    }

    private void test1(User user){
        save3(user);
    }

    @Transactional(rollbackFor = Exception.class)
    public void save3(User user) {
        userExService.save2(user);
        throw new RuntimeException("异常");
    }

}
