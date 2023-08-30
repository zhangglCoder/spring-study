package cn.zpro.spring.springevent.controller;

import cn.zpro.spring.springevent.entity.User;
import cn.zpro.spring.springevent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author guolong.zhang
 * @date 2023/08/10 09:57
 **/
@RestController
public class ReNameController {

    @Autowired
    private UserService userService;
    /**
     * 插入数据
     */
    @GetMapping("add")
    public void test() throws Exception {

    }
}
