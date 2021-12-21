package com.voorraad.voorraad.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig extends RabbitConfigAdapter {

    public static String x = "";
    public static String y = "";
    public static String z = "";

    @Bean
    public Queue queue() {
        return new Queue("");
    }

    @Bean
    public Exchange exchange() {
        return new DirectExchange("");
    }

    @Bean
    public Binding keywordsBinding() {
        return super.keywordsBinding("");
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
