package com.edu.rabbit.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProducerShenY {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @RequestMapping("/send/{msg}")
    public void send (@PathVariable("msg") String msg){
        rabbitTemplate.convertAndSend("shenyang",msg);
    }
}
