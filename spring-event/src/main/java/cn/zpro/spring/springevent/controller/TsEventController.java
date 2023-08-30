package cn.zpro.spring.springevent.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.thread.ThreadUtil;
import cn.zpro.spring.springevent.entity.User;
import cn.zpro.spring.springevent.event.JdkEvent;
import cn.zpro.spring.springevent.event.ObjEvent;
import cn.zpro.spring.springevent.event.UserEvent;
import cn.zpro.spring.springevent.event.UserExtEvent;
import cn.zpro.spring.springevent.service.UserExService;
import cn.zpro.spring.springevent.service.UserService;
import cn.zpro.spring.springevent.service.impl.UserEx2ServiceImpl;
import cn.zpro.spring.springevent.service.impl.UserEx3ServiceImpl;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;

/**
 *
 * 事务
 * @author guolong.zhang
 * @date 2022/04/14 15:24
 **/
@RestController
public class TsEventController {

    @Autowired
    private UserEx3ServiceImpl userExService;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;


    /**
     * 泛型参数-特性
     */
    @GetMapping("test")
    public String test(HttpServletRequest req, HttpServletResponse response) throws Exception {
        BufferedInputStream inputStream = FileUtil.getInputStream("/Users/zhangguolong/Downloads/20220507103311.pdf");
        System.out.println("开始生成PDF...");
        Thread.sleep(10 * 1000);

        response.setHeader("content-disposition","attachment;fileName="+ URLEncoder.encode("test.pdf","UTF-8"));
        //获取输出流
        ServletOutputStream os = response.getOutputStream();
        //复制
        IOUtils.copy(inputStream,os);
        System.out.println("完成生成PDF");
        return "test";
    }
    /**
     * 泛型参数-特性
     */
    @GetMapping("generics")
    public void generics() {
        ObjEvent<JdkEvent> jdkEventObjEvent = new ObjEvent<>();
        JdkEvent jdkEvent = new JdkEvent();
        jdkEvent.setName("我是原生对象");
        jdkEventObjEvent.setOption(jdkEvent);
        jdkEventObjEvent.setFlag(false);
        applicationEventPublisher.publishEvent(jdkEventObjEvent);
    }

    @GetMapping("push")
    public void push() {
        User user = new User();
        user.setName("注册用户");
        UserExtEvent userEvent = new UserExtEvent(user);
        applicationEventPublisher.publishEvent(userEvent);
    }

    @GetMapping("register")
    public void register() {
        User user = new User();
        user.setName("推送用户");
        userExService.save(user);
    }

    public static void main(String[] args) {
        System.out.println(1|2);
    }

}
