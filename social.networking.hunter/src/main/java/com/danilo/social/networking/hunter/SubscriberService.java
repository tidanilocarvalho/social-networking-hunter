package com.danilo.social.networking.hunter;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriberService
{
    private static final Logger LOGGER = LoggerFactory.getLogger(SubscriberService.class);

    @Autowired
    private MqttConnectionFactory mqttConnectionFactory;
    
    public void subscribe(String topic) {
        try
        {
            mqttConnectionFactory.getMqttClient().subscribe(topic);

            LOGGER.debug("Subscribed on topic {}", topic);
        }
        catch (MqttException e)
        {
            LOGGER.error("Error subscribing on topic {}", topic, e);
        }
    }
}
