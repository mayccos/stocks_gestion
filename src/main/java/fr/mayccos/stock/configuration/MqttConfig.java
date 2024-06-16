package fr.mayccos.stock.configuration;


import com.fasterxml.jackson.databind.ObjectMapper;
import fr.mayccos.stock.manager.LogStockManager;
import fr.mayccos.stock.pojo.LogStock;
import fr.mayccos.stock.service.LogStockService;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqttConfig {


    @Value("${mqtt.brocker.url}")
    private String brockerURL;

    @Value("${mqtt.client.id}")
    private String clientId;

    @Value("${mqtt.username}")
    private  String username;

    @Value("${mqtt.password}")
    private String password;

    @Autowired
    private LogStockManager logStockManager;



    @Bean
    public MqttClient mqttClient() throws MqttException {
        // Client instantiation
        MqttClient mqttClient = new MqttClient(brockerURL, clientId, new MemoryPersistence());

        // additional arguments
        MqttConnectOptions options = new MqttConnectOptions();
        options.setUserName(username);
        options.setPassword(password.toCharArray());
        mqttClient.connect(options);

        //callback
        mqttClient.setCallback(new MqttCallback() {
            @Override
            public void connectionLost(Throwable throwable) {
                System.out.println("Connection lost : " + throwable.getMessage());
            }

            @Override
            public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
                System.out.println("Message arrived : " + mqttMessage.toString());
                String payload = new String(mqttMessage.getPayload());

                //to serialize the received message to Java's object
                ObjectMapper objectMapper = new ObjectMapper();
                LogStock logStock = objectMapper.readValue(payload, LogStock.class);
                logStockManager.processLog(logStock);
            }

            @Override
            public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
                System.out.println("Delivery complete : " + iMqttDeliveryToken.getMessageId());

            }
        });
        mqttClient.subscribe("product");
        return mqttClient;
    }


}
