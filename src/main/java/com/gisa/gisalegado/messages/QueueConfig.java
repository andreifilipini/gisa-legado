package com.gisa.gisalegado.messages;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Component
public class QueueConfig {

    @Inject
    private AmqpAdmin amqpAdmin;

    @Value("${queue.changePlanLegacy}")
    private String changePlanLegacyQueueName;

    @Value("${queue.changePlanLegacyResult}")
    private String changePlanLegacyResultQueueName;

    @PostConstruct
    protected void createQueues() {
        amqpAdmin.declareQueue(new Queue(this.changePlanLegacyQueueName, true));
        amqpAdmin.declareQueue(new Queue(this.changePlanLegacyResultQueueName, true));
    }
}
