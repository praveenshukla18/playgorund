package com.ps.covidportal.services;

import com.ps.covidportal.services.beans.StateData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/covidportal")
public class CovidPortalRestController {

    @Autowired
    private Environment env;

    @GetMapping("/countStatistics")
    public Map<String, StateData> getCountStatistics(){

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Map<String, StateData>> stateResponse = restTemplate.exchange(env.getProperty("covid.stat.url"),
                HttpMethod.GET, null, new ParameterizedTypeReference<Map<String, StateData>>() {
        });
        return stateResponse.getBody();
    }
}
