package cn.zpro.spring.springevent.controller;

import cn.hutool.core.io.FileUtil;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.net.URLEncoder;

/**
 *
 * @author guolong.zhang
 * @date 2023/05/10 11:39
 **/
@RestController
public class TestController {

    /**
     * 泛型参数-特性
     */
    @GetMapping("test222")
    public void test(HttpServletRequest req, HttpServletResponse response) throws Exception {
        String requestURI = req.getRequestURI();
        System.out.println(requestURI);
    }
}
