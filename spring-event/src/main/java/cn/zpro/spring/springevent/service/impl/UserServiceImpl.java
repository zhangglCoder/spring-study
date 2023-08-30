package cn.zpro.spring.springevent.service.impl;

import cn.zpro.spring.springevent.service.UserEx2Service;
import cn.zpro.spring.springevent.service.UserExService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.zpro.spring.springevent.entity.User;
import cn.zpro.spring.springevent.service.UserService;
import cn.zpro.spring.springevent.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
* @author zhangguolong
* @description 针对表【user】的数据库操作Service实现
* @createDate 2022-05-29 11:03:58
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{


}




