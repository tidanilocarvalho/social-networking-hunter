package com.danilo.social.networking.hunter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigProperties {
    
    @Bean
    @ConfigurationProperties(prefix = "mqtt")
    public MqttConfig item() {
        return new MqttConfig();
    }
}