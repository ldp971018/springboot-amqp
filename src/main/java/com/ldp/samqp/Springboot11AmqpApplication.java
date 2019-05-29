package com.ldp.samqp;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit //开启注解模式的RabbitMQ模式
@SpringBootApplication
public class Springboot11AmqpApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot11AmqpApplication.class, args);
    }

}
