package com.edu.stu.sport.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class RabbitConfig {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Bean
    public Queue getQueue(){
        return new Queue("jinzhou");
    }

    public RabbitTemplate rabbitTemplate(){
            rabbitTemplate.setMandatory(true);
        // 消息返回, yml需要配置 publisher-returns: true
            rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> {
                log.debug("消息：{} 发送失败, 应答码：{} 原因：{} 交换机: {}  路由键: {}", message, replyCode, replyText, exchange, routingKey);
            });
            rabbitTemplate.setConfirmCallback(((correlationData, ack, cause) ->{
                if(ack){
                   log.info("消费成功");
                }else {
                    log.info("消费失败");
                }
            } ));
            return  rabbitTemplate;
    }

}
