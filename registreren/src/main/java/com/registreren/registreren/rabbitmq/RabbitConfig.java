package com.registreren.registreren.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig extends RabbitConfigTemplate{

    @Bean
    public Queue queue(){
        return new Queue("post_user_queue");
    }

    @Bean
    public Exchange exchange(){
        return new DirectExchange("user_exchange");
    }

    @Override
    public BindingBuilder.GenericArgumentsConfigurer keywordsBinding() {
        return super.keywordsBinding();
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
