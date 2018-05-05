package com.autuan.blog.listen;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "blog")
public class TestListen {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("Reciever:"+hello);
        System.out.println("------over----");
    }
}
