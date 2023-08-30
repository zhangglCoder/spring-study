package cn.zpro.spring.springevent.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 
 * @TableName user
 */
@Data
public class User implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 认证过期时间
     */
    private Date certExpiredTime;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private Integer age;

    /**
     * 
     */
    private String address;

    /**
     * 
     */
    private String dept;

    /**
     * 
     */
    private String test;

    private static final long serialVersionUID = 1L;
}