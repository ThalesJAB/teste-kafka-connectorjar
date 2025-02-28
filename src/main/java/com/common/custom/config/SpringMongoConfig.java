package com.common.custom.config;

import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.common.custom.repositories")
public class SpringMongoConfig {

    @Bean
    public MongoTemplate mongoTemplate() {
        String mongoUri = "mongodb://root:example@mongodb:27017/?authSource=admin"; // Ajuste conforme necessário
        return new MongoTemplate(MongoClients.create(mongoUri), "mydatabase"); // Troque "myDatabase" pelo nome do seu banco
    }
}