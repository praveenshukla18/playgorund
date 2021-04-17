package com.ps.playground;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
public class DBInitApplicationListener implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    UserRepository userRepository;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        try {

            InputStream in = new ClassPathResource("MOCK_DATA.json").getInputStream();
            ObjectMapper objectMapper = new ObjectMapper();
            List<User> users = objectMapper.readValue(in, new TypeReference<List<User>>(){});
            userRepository.saveAll(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
