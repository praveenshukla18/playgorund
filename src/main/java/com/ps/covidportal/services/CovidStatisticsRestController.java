package com.ps.covidportal.services;

import com.ps.covidportal.services.beans.CaseStat;
import com.ps.covidportal.services.beans.StateData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/covidStat")
public class CovidStatisticsRestController {

    @Autowired
    private CovidStatisticsService covidStatisticsService;

    @GetMapping
    public Map<String, StateData> getCountStatistics(){
        return covidStatisticsService.getCountStatistics();
    }

    @GetMapping("/{state}")
    public StateData getStateStatistics(@PathVariable("state") String state){
        return covidStatisticsService.getStateData(state);
    }

    @GetMapping("/{state}/{district}")
    public CaseStat getDistrictStatistics(@PathVariable("state") String state,
                                          @PathVariable("district") String district){
        return covidStatisticsService.getDistrictData(state, district);
    }
}
