package com.ps.covidportal.services.beans;

import java.util.Map;

public class StateData {

    private Map<String, CaseStat> districtData;
    private String statecode;

    public StateData() {
    }

    public Map<String, CaseStat> getDistrictData() {
        return districtData;
    }

    public void setDistrictData(Map<String, CaseStat> districtData) {
        this.districtData = districtData;
    }

    public String getStatecode() {
        return statecode;
    }

    public void setStatecode(String statecode) {
        this.statecode = statecode;
    }
}
