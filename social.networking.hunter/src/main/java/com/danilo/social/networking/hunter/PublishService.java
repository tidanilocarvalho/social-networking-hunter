package com.danilo.social.networking.hunter;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublishService
{
    private static final Logger LOGGER = LoggerFactory.getLogger(PublishService.class);

    @Autowired
    private MqttConnectionFactory mqttConnectionFactory;
    
    public void publish(PublishMessage publishMessage) {
        try
        {
            LOGGER.debug("Starting publish message {}", publishMessage);

            MqttMessage message = new MqttMessage(publishMessage.getMessage().getBytes());
            message.setQos(publishMessage.getQos());
            
            mqttConnectionFactory.getMqttClient().publish(publishMessage.getTopic(), message);

            LOGGER.debug("Message {} publishe successfully", publishMessage);
        }
        catch (MqttException e)
        {
            LOGGER.error("Error publishing message {}", publishMessage, e);
        }
    }
    
}
