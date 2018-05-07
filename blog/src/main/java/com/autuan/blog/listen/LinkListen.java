package com.autuan.blog.listen;

import com.autuan.blog.entity.Link;
import com.autuan.blog.service.LinkService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class LinkListen {
    @Autowired
    private LinkService linkService;

    @RabbitListener(queues = "link")
    public void process(int linkId) {
        try {
            Long timeInterval = (long) (Math.random()*10000) ;
            System.out.println("time is " + timeInterval);
            Thread.sleep(timeInterval);
            System.out.println("time is " + timeInterval);
            System.out.println("link id is " + linkId);
            // 尝试 ping 博客
            // 修改状态
            linkService.updateLinkStatus(linkId);
            // 记录日志
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
