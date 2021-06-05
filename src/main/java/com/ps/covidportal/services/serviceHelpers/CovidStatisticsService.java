package com.ps.covidportal.services.serviceHelpers;

import com.ps.covidportal.services.beans.CaseStat;
import com.ps.covidportal.services.beans.StateData;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CovidStatisticsService extends CovidPortalService{

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

}
