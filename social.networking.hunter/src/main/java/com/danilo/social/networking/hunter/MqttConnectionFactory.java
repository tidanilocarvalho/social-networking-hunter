package com.danilo.social.networking.hunter;

import javax.annotation.PostConstruct;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MqttConnectionFactory
{
    private static final Logger LOGGER = LoggerFactory.getLogger(MqttConnectionFactory.class);

    @Autowired
    private MqttConfig mqttConfig;
    
    private MqttClient mqttClient;
    
    @PostConstruct
    public void init()
    {
        connect();
    }

    private void connect()
    {
        try
        {
            LOGGER.info("Starting connection to mqtt broker {} with id {}", mqttConfig.getBroker(), mqttConfig.getClientId());

            MqttConnectOptions connectOptions = new MqttConnectOptions();
            connectOptions.setCleanSession(true);
            
            MemoryPersistence persistence = new MemoryPersistence();
            
            mqttClient = new MqttClient(mqttConfig.getBroker(), mqttConfig.getClientId(), persistence);
            
            mqttClient.connect();

            mqttClient.setCallback(new MessageArrivedCallback());
            
            LOGGER.info("Connected succefully to mqtt broker {} with id {}", mqttConfig.getBroker(), mqttConfig.getClientId());
        }
        catch (MqttException e)
        {
            LOGGER.error("Error during mqtt broker {} connection with id {}", mqttConfig.getBroker(), mqttConfig.getClientId(), e);
        }
    }

    public MqttClient getMqttClient()
    {
        return mqttClient;
    }
}
