package com.registreren.registreren.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;

public abstract class RabbitConfigAdapter {

    private MessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }

    public abstract Queue queue();

    public abstract Exchange exchange();

    public Binding keywordsBinding(String routingKey) {
        return BindingBuilder
                .bind(queue())
                .to(exchange())
                .with(routingKey).noargs();
    }

    public AmqpTemplate template(ConnectionFactory connectionFactory){
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);

        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }
}
