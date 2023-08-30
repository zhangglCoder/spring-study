package cn.zpro.spring.springevent.event;

import lombok.Data;

/**
 * 类的描述
 *
 * @author guolong.zhang
 * @date 2022/06/11 14:12
 **/
@Data
public class ObjEvent<T> {

    private T option;

    private boolean flag;
}
