package com.example.temp.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer {

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare("this-is-my-queue", false, false, false, null);


        channel.basicConsume("this-is-my-queue", true, (consumertag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println("i just reveived a message = " + message);
        }, consumertag -> { });
    }

}
