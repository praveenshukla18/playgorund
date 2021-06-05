package com.ps.covidportal.services.serviceHelpers;

import com.ps.covidportal.services.beans.CaseStat;
import com.ps.covidportal.services.beans.StateData;
import com.ps.covidportal.services.resultbeans.CovidTotalSummary;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CovidSummaryService extends CovidPortalService{

    public Map<String, CovidTotalSummary> getTotalSummary(){
        Map<String, StateData> completeStats = getCompleteStat();
        Map<String, CovidTotalSummary> covidTotalSummaryMap = new HashMap<>();
        completeStats.forEach((stateName, stateData) -> {
            Map<String, CaseStat> districtData = stateData.getDistrictData();
            CovidTotalSummary covidTotalSummary = getTotalSummaryForDistricts(districtData);
            covidTotalSummaryMap.put(stateName, covidTotalSummary);
        });
        return covidTotalSummaryMap;
    }

    public CovidTotalSummary getTotalSummaryForState(String state){
        Map<String, StateData> completeStats = getCompleteStat();
        if(completeStats == null || completeStats.get(state) == null){
            return new CovidTotalSummary();
        }
        StateData stateData = completeStats.get(state);
        if(stateData.getDistrictData() == null){
            return new CovidTotalSummary();
        }
        return getTotalSummaryForDistricts(stateData.getDistrictData());
    }

    private CovidTotalSummary getTotalSummaryForDistricts(Map<String, CaseStat> districtData){
        CovidTotalSummary covidTotalSummary = new CovidTotalSummary();
        districtData.forEach((districtName, caseStat) -> {
            covidTotalSummary.setActive(covidTotalSummary.getActive()+caseStat.getActive());
            covidTotalSummary.setDeceased(covidTotalSummary.getDeceased()+caseStat.getDeceased());
            covidTotalSummary.setConfirmed(covidTotalSummary.getConfirmed()+caseStat.getConfirmed());
            covidTotalSummary.setRecovered(covidTotalSummary.getRecovered()+covidTotalSummary.getRecovered());
        });
        return covidTotalSummary;
    }
}
