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


    private final static String POST_USER_ROUTING_KEY = "post_user_key";

    @Bean
    public Queue queue(){
        return new Queue("post_user_queue");
    }

    @Bean
    public Exchange exchange(){
        return new DirectExchange("user_exchange");
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
