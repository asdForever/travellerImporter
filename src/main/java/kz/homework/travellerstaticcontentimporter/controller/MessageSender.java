package kz.homework.travellerstaticcontentimporter.controller;

import kz.homework.travellerstaticcontentimporter.configuration.MessageQueueConfiguration;
import kz.homework.travellerstaticcontentimporter.dto.CityDTO;
import kz.homework.travellerstaticcontentimporter.dto.CountryDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public record MessageSender(RabbitTemplate rabbitTemplate) {

    public void broadcastCountry(CountryDTO countryDTO) {
        this.rabbitTemplate.convertAndSend(MessageQueueConfiguration.COUNTRY_EXCHANGE_NAME, "", countryDTO);
    }

    public void broadcastCity(CityDTO cityDTO) {
        this.rabbitTemplate.convertAndSend(MessageQueueConfiguration.CITY_EXCHANGE_NAME, "", cityDTO);
    }
}
