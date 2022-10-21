package com.nahorniak.publisher.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    public static final String QUEUE1 = "myTopicQueue1";
    public static final String QUEUE2 = "myTopicQueue2";
    public static final String QUEUE3 = "myTopicQueue3";

    public static final String MY_TOPIC_ROUTING_KEY_1 = "myTopicQueue1.#";
    public static final String MY_TOPIC_ROUTING_KEY_2 = "#.myTopicQueue2";
    public static final String MY_TOPIC_ROUTING_KEY_3 = "*.myTopicQueue3";

    public static final String EXCHANGE = "topic.exchange";

    @Bean
    public Queue myQueue1() {
        return  new Queue(QUEUE1);
    }

    @Bean Queue myQueue2(){ return  new Queue(QUEUE2);}

    @Bean Queue myQueue3(){ return  new Queue(QUEUE3);}

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Binding binding1(Queue myQueue1, TopicExchange exchange) {
        return BindingBuilder
                .bind(myQueue1)
                .to(exchange)
                .with(MY_TOPIC_ROUTING_KEY_1);
    }

    @Bean
    public Binding binding2(Queue myQueue2, TopicExchange exchange){
        return BindingBuilder
                .bind(myQueue2)
                .to(exchange)
                .with(MY_TOPIC_ROUTING_KEY_2);
    }

    @Bean
    public Binding binding3(Queue myQueue3, TopicExchange exchange){
        return BindingBuilder
                .bind(myQueue3)
                .to(exchange)
                .with(MY_TOPIC_ROUTING_KEY_3);
    }

    @Bean
    public MessageConverter messageConverter() {
        return  new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return  template;
    }

}
