package com.common.custom.task;

import com.common.custom.App;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.common.custom.model.User;
import com.common.custom.repositories.UserRepository;
import org.apache.kafka.connect.data.Field;
import org.apache.kafka.connect.sink.SinkRecord;
import org.apache.kafka.connect.data.Struct;
import org.apache.kafka.connect.data.Schema;
import org.apache.kafka.connect.sink.SinkTask;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CustomSinkTask extends SinkTask {

    private UserRepository userRepository;

    @Override
    public void start(Map<String, String> map) {
        // Inicializa o contexto do Spring
        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        this.userRepository = context.getBean(UserRepository.class);
    }

    @Override
    public void put(Collection<SinkRecord> records) {
        for (SinkRecord record : records) {
            String topic = record.topic();
            ObjectMapper objectMapper = new ObjectMapper(); // Cria um ObjectMapper do Jackson
            Struct valueStruct = (Struct) record.value();

            System.out.println("Received record Struct: " + valueStruct);


            try {
                // Converte o Struct para um Map
                Map<String, Object> structAsMap = new HashMap<>();
                for (Field field : valueStruct.schema().fields()) {
                    String fieldName = field.name();
                    Object fieldValue = valueStruct.get(field);
                    structAsMap.put(fieldName, fieldValue);
                }

                System.out.println("Processed Map: " + structAsMap);

                // Converte o Map para JSON
                String jsonString = objectMapper.writeValueAsString(structAsMap);
                System.out.println("Processed JSON String: " + jsonString);


                // Se precisar de um JSONObject, você pode criar a partir da string
                JSONObject json = new JSONObject(jsonString);

                System.out.println("Processed JSONObject: " + json);

                switch (topic) {
                    case "users-topic":
                        User user = new User();
                        user.setName(json.getString("name"));
                        user.setEmail(json.getString("email"));
                        userRepository.save(user);
                        break;
                    default:
                        System.out.println("Tópico desconhecido: " + topic);
                }
            } catch (Exception e) {
                System.err.println("Failed to convert Struct to JSON: " + e.getMessage());
                e.printStackTrace();
            }


        }
    }

    @Override
    public void stop() {
    }

    @Override
    public String version() {
        return "1.0";
    }
}
