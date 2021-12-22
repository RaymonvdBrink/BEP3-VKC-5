package com.gerecht.gerecht.infrastructure.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gerecht.gerecht.infrastructure.driven.messaging.RabbitMqEventPublisher;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class RabbitMqConfig {

    @Value("${spring.rabbitmq.host}")
    private String host;

    @Value("${spring.rabbitmq.port}")
    private int port;

    @Value("${messaging.exchange.gerechtboard}")
    private String gerechtBoardExchangeName;

    @Value("${messaging.queue.gerecht-keywords}")
    private String gerechtQueueName;
    @Value("${messaging.queue.all-keywords}")
    private String allKeywordsQueueName;

    @Value("${messaging.routing-key.gerecht-keywords}")
    private String gerechtKeywordsRoutingKey;
    @Value("${messaging.routing-key.all-keywords}")
    private String keywordsRoutingKey;

    @Bean
    public TopicExchange gerechtBoardExchange() {
        return new TopicExchange(gerechtBoardExchangeName);
    }
    public Queue keywordsQueue() {
        return QueueBuilder.durable(allKeywordsQueueName).build();
    }

    @Bean
    public Queue gerechtQueue() {
        return QueueBuilder.durable(gerechtQueueName).build();
    }

    @Bean
    public Binding gerechtKeywordsBinding() {
        return BindingBuilder
                .bind(gerechtQueue())
                .to(gerechtBoardExchange())
                .with(gerechtKeywordsRoutingKey);
    }
    @Bean
    public Binding keywordsBinding() {
        return BindingBuilder
                .bind(keywordsQueue())
                .to(gerechtBoardExchange())
                .with(keywordsRoutingKey);
    }

    @Bean
    public RabbitMqEventPublisher EventPublisher(RabbitTemplate template) {
        return new RabbitMqEventPublisher(template, gerechtBoardExchangeName);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(Jackson2JsonMessageConverter converter) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory());
        rabbitTemplate.setMessageConverter(converter);

        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter converter(Jackson2ObjectMapperBuilder builder) {
        // We need to configure a message converter to be used by RabbitTemplate.
        // We could use any format, but we'll use JSON so it is easier to inspect.
        ObjectMapper objectMapper = builder
                .createXmlMapper(false)
                .build();

        Jackson2JsonMessageConverter converter = new Jackson2JsonMessageConverter(objectMapper);

        // Set this in order to prevent deserialization using the sender-specific
        // __TYPEID__ in the message header.
        converter.setAlwaysConvertToInferredType(true);

        return converter;
    }

    @Bean
    MessageConverter getConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        return new CachingConnectionFactory(host, port);
    }

}
