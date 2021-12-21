package com.registreren.registreren.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig extends RabbitConfigAdapter {


    public static String POST_USER_ROUTING_KEY = "post_user_key";
    public static String POST_USER_QUEUE = "post_user_queue";
    public static String MAIN_USER_EXCHANGE = "user_exchange";

    @Bean
    public Queue queue(){
        return new Queue(POST_USER_QUEUE);
    }

    @Bean
    public Exchange exchange(){
        return new DirectExchange(MAIN_USER_EXCHANGE);
    }

    @Bean
    public Binding keywordsBinding() {
        return super.keywordsBinding(POST_USER_ROUTING_KEY);
    }

    @Bean
    MessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }

    @Override
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        return super.template(connectionFactory);
    }
}
