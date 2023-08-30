package cn.zpro.event.bus.entity;

/**
 * 类的描述
 *
 * @author guolong.zhang
 * @date 2022/05/20 13:34
 **/
public class User {
    private String id;

    private String pid;

    private String name;

    private String value;

    public User() {

    }

    public User(String id, String pid, String name, String value) {
        this.id = id;
        this.pid = pid;
        this.name = name;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", pid='" + pid + '\'' +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
