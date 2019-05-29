package com.ldp.samqp.service;

import com.ldp.samqp.bean.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author Return
 * @create 2019-05-28 20:24
 */
@Service
public class Userservice {

    @RabbitListener(queues = "ldp")
    public void getMsg(User user){
        //当监听到队列atguigu收到了消息就会触发此方法
        System.out.println("董事长信息==>"+user);
    }
}
