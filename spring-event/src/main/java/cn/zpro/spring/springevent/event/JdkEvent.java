package cn.zpro.spring.springevent.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 模拟自定义事件
 *
 * @author guolong.zhang
 * @date 2022/05/05 19:08
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JdkEvent {

    private String name;
}
