package com.company.productapp.listener;

import com.company.productapp.entity.Category;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Slf4j
@Component
public class CategoryListener {

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "categories")
    public void listenTopicCategory(String body) throws IOException {

        List<Category> categories = objectMapper.readValue(body, new TypeReference<List<Category>>(){});

        for (Category c: categories) {
            log.info("Categories Received {}", c);
        }
    }

}
