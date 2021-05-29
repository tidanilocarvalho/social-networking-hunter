package com.danilo.social.networking.hunter;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageArrivedCallback implements MqttCallback
{
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageArrivedCallback.class);

    @Override
    public void connectionLost(Throwable cause)
    {
        LOGGER.error("Connection lost", cause);
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception
    {
        LOGGER.info("Message {} arrived for topic {}", new String(message.getPayload()), topic);
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token)
    {
        LOGGER.debug("Delivery complete for messageId {}", token.getMessageId());
    }
}
