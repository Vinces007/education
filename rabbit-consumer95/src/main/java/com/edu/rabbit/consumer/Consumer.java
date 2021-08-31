package com.edu.rabbit.consumer;


import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.jdom2.output.XMLOutputter;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
@Slf4j
public class Consumer {

    @RabbitListener(queues = "shenyang")
    @RabbitHandler
    public void process(String msg){
        log.info("shenyang消费"+msg);
    }
    @RabbitListener(queues = "jinzhou")
    @RabbitHandler
    public void processJz(Map<String,Object> map){
        log.info("jinzhou消费"+map.get("id").toString());
        log.info("data"+map.get("data").toString());
    }

}
