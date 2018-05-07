package com.autuan.blog.config;

import com.autuan.blog.entity.Link;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SenderCompent {
    @Autowired
    private AmqpTemplate rabbit;

    public void send(){
        String context = "hi " + new Date();
        System.out.println("Sender : " + context);
        this.rabbit.convertAndSend("blog", context);
    }

    public void sendLink(int linkId){
        String context = "";
        this.rabbit.convertAndSend("link",linkId);
    }
}
