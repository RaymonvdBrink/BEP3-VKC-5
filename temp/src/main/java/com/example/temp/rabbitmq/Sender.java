package com.example.temp.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.TimeoutException;

public class Sender {

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();

        try (Connection connection = factory.newConnection()) {
            Channel channel = connection.createChannel();
            channel.queueDeclare("this-is-my-queue", false, false, false, null);

            String message = "dit is een message, tijd: " + LocalDateTime.now();

            channel.basicPublish("", "this-is-my-queue", false, null, message.getBytes());

            System.out.println("message has been sent");

        }
    }
}
