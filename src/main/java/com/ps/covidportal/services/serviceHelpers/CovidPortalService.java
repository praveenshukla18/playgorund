package com.ps.covidportal.services.serviceHelpers;

import com.ps.covidportal.services.beans.StateData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

abstract public class CovidPortalService {

    @Autowired
    private Environment env;

    @Autowired
    private RestTemplate restTemplate;

    protected Map<String, StateData> getCompleteStat(){
        ResponseEntity<Map<String, StateData>> stateResponse = restTemplate.exchange(env.getProperty("covid.stat.url"),
                HttpMethod.GET, null, new ParameterizedTypeReference<Map<String, StateData>>() {
                });
        return stateResponse.getBody();
    }
}
