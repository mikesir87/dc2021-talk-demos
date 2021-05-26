package io.mikesir87.dc2021demo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoClientProvider {

    @Value("${mongoConnectionUrl}")
    private String connectionString;

    public @Bean MongoClient mongoClient() {
        return MongoClients.create(connectionString);
    }

}
