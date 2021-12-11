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

    @Bean
    public BindingBuilder.GenericArgumentsConfigurer binding(Queue queue, Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("post_user_key");
    }

    @Bean
    MessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory){
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);

        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }
}
