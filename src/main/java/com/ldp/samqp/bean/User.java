package com.ldp.samqp.bean;

/**
 * @author Return
 * @create 2019-05-28 20:15
 */
public class User {

    private String name;
    private String msg;

    public User() {
        super();
    }

    public User(String name, String msg) {
        this.name = name;
        this.msg = msg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
