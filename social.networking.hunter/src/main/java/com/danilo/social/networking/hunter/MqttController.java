package com.danilo.social.networking.hunter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MqttController
{
    @Autowired 
    private PublishService publishService;

    @Autowired 
    private SubscriberService subscriberService;

    @PostMapping (path = "/publish")
    public ResponseEntity<PublishMessage> publish(@RequestBody PublishMessage publishMessage)
    {
        publishService.publish(publishMessage);
        
        return ResponseEntity.ok().body(publishMessage);
    }
    
    @PostMapping (path = "/subscribe")
    public ResponseEntity<SubscribeTopic> subscribe(@RequestBody SubscribeTopic subscribeTopic)
    {
        subscriberService.subscribe(subscribeTopic.getTopic());
        
        return ResponseEntity.ok().body(subscribeTopic);
    }
}
