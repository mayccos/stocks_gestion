package fr.mayccos.stock.configuration;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqttConfig {

    @Value("${mqtt.brocker.url}")
    private String brockerUrl;

    @Value("${mqtt.client.id}")
    private String clientId;

    @Value("${mqtt.username}")
    private  String username;

    @Value("${mqtt.password}")
    private String password;
}
