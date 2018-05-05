package com.autuan.blog.listen;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "link")
public class LinkListen {

    @RabbitHandler
    public void process(String string) {
        try {
            Long timeInterval = (long) (Math.random()*1000);
            System.out.println("time is " + timeInterval);
            Thread.sleep(timeInterval);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
