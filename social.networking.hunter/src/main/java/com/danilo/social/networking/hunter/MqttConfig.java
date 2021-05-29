package com.danilo.social.networking.hunter;

public class MqttConfig {

    private String broker;
    private String clientId;

    public String getBroker()
    {
        return broker;
    }

    public void setBroker(String broker)
    {
        this.broker = broker;
    }

    public String getClientId()
    {
        return clientId;
    }

    public void setClientId(String clientId)
    {
        this.clientId = clientId;
    }
}