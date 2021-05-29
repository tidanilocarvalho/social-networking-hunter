package com.danilo.social.networking.hunter;

public class PublishMessage
{
    private int qos = 2;
    private String message;
    private String topic;

    public int getQos()
    {
        return qos;
    }

    public void setQos(int qos)
    {
        this.qos = qos;
    }
    
    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public String getTopic()
    {
        return topic;
    }

    public void setTopic(String topic)
    {
        this.topic = topic;
    }
}
