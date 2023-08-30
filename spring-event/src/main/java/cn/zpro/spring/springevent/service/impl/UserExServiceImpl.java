package cn.zpro.spring.springevent.service.impl;

import cn.zpro.spring.springevent.entity.User;
import cn.zpro.spring.springevent.service.UserEx2Service;
import cn.zpro.spring.springevent.service.UserExService;
import cn.zpro.spring.springevent.service.UserService;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 类的描述
 *
 * @author guolong.zhang
 * @date 2022/05/29 13:37
 **/
@Service
public class UserExServiceImpl implements UserExService {

    @Autowired
    private UserService userService;


    @Override
    public void save2(User user) {
       userService.save(user);
    }
}
