package com.nahorniak.publisher.service;

import com.nahorniak.publisher.config.AppConfig;
import com.nahorniak.publisher.messages.CustomMessage;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MessagePublisherService {

    private final RabbitTemplate template;

    public void send(CustomMessage customMessage){
        customMessage.setMessageId(UUID.randomUUID().toString());
        customMessage.setMessageDate(new Date());
        template.convertAndSend(AppConfig.EXCHANGE,customMessage.getRoutingKey(),customMessage);
    }

}
