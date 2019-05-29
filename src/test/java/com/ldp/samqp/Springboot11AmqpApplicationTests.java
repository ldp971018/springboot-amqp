package com.ldp.samqp;

import com.ldp.samqp.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot11AmqpApplicationTests {

    //用于接受和发送消息
    @Autowired
    private RabbitTemplate rabbitTemplate;

    //用于管理交换器和队列的管理
    @Autowired
    private AmqpAdmin amqpAdmin;

    @Test
    public void create(){
        //创建一个单点的消息交换策略
//        amqpAdmin.declareExchange(new DirectExchange("ldp.direct"));
        //创建一个队列信息
//        amqpAdmin.declareQueue(new Queue("ldp",true));
        //绑定关系
//        Binding(String destination,
//            Binding.DestinationType destinationType,
//           String exchange,
//           String routingKey,
//            Map<String, Object> arguments)
        amqpAdmin.declareBinding(new Binding("ldp",Binding.DestinationType.QUEUE,"ldp.direct","ldp",null));
    }

    @Test
    public void contextLoads() {
//        void convertAndSend(String var1, String var2, Object var3) throws AmqpException;
        Map<String, Object> map = new HashMap<>();
        map.put("msg","这是从springboot发来的消息");
        map.put("data",Arrays.asList("hello","world",123,true));
        rabbitTemplate.convertAndSend("exchange.direct","atguigu",map);
    }

    //接受数据
    @Test
    public void getMsg(){
        Object atguigu = rabbitTemplate.receiveAndConvert("atguigu");
        System.out.println(atguigu.getClass());
        System.out.println(atguigu);
    }

    //广播
    @Test
    public void seed(){
//        rabbitTemplate.convertAndSend("exchange.fanout","atguigu",new User("刘东平","Java软件开发工程师"));
        rabbitTemplate.convertAndSend("ldp.direct","ldp",new User("刘东平","Java软件开发工程师"));
    }

}
