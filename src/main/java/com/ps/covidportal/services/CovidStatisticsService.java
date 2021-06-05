package com.ps.covidportal.services;

import com.ps.covidportal.services.beans.CaseStat;
import com.ps.covidportal.services.beans.StateData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class CovidStatisticsService {

    @Autowired
    private Environment env;

    @Autowired
    private RestTemplate restTemplate;

    public Map<String, StateData> getCountStatistics(){
        return getCompleteStat();
    }

    public StateData getStateData(String state){
        Map<String, StateData> completeStats = getCompleteStat();
        return completeStats != null ? completeStats.get(state) : null;
    }

    public CaseStat getDistrictData(String state, String district){
        Map<String, StateData> completeStats = getCompleteStat();
        if(completeStats == null || completeStats.get(state) == null){
            return null;
        }
        StateData stateData = completeStats.get(state);
        return stateData.getDistrictData().get(district);
    }

    private Map<String, StateData> getCompleteStat(){
        ResponseEntity<Map<String, StateData>> stateResponse = restTemplate.exchange(env.getProperty("covid.stat.url"),
                HttpMethod.GET, null, new ParameterizedTypeReference<Map<String, StateData>>() {
                });
        return stateResponse.getBody();
    }
}
