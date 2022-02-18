package com.gisa.gisalegado.messages;

import com.gisa.gisacore.messages.AbstractRabbitConsumer;
import com.gisa.gisalegado.dto.ChangePlanLegacyRequestDTO;
import com.gisa.gisalegado.dto.ChangePlanLegacyResponseDTO;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Slf4j
@Component
public class ChangePlanLegacyConsumer extends AbstractRabbitConsumer {

    @Inject
    private RabbitTemplate rabbitTemplate;


    @Value("${queue.changePlanLegacyResult}")
    private String changePlanLegacyResultQueueName;

    @RabbitListener(queues = {"${queue.changePlanLegacy}"})
    protected void receive(@Payload String body) {
        executeLoggin(body);
    }

    @Override
    protected void execute(@Payload String body) {
        Gson gson = new Gson();
        ChangePlanLegacyRequestDTO request = gson.fromJson(body, ChangePlanLegacyRequestDTO.class);
        // TODO,  para fins de simulação toda alteração de plano será aprovada.
        ChangePlanLegacyResponseDTO response = new ChangePlanLegacyResponseDTO(request.getTransactionId(), true, request.getIdAssociado(), request.getPlanoId());
        rabbitTemplate.convertAndSend(this.changePlanLegacyResultQueueName, gson.toJson(response));
    }

    @Override
    protected Logger getLogger() {
        return log;
    }
}
