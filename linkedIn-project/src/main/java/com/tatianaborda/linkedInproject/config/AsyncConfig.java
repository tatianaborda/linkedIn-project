package com.tatianaborda.linkedInproject.config;

import com.tatianaborda.linkedInproject.async.MessageListener;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AsyncConfig {

    private static final String QUEUE_NAME = "person-finder";

    private static final String EXCHANGE_NAME = "services";

    @Bean
    public Queue queue(){
        return new Queue(QUEUE_NAME, false);
    }

    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange)
                .with("meeting.message.person");
    }

    @Bean
    public MessageListenerAdapter listenerAdapter(MessageListener listener){
        return new MessageListenerAdapter(listener, "receiveMessage");
    }

    @Bean
    public SimpleMessageListenerContainer container(
            ConnectionFactory connectionFactory,
            MessageListenerAdapter listenerAdapter){
        SimpleMessageListenerContainer container =
                new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addQueueNames(QUEUE_NAME);
        container.setMessageListener(listenerAdapter);
        return container;
    }
}
