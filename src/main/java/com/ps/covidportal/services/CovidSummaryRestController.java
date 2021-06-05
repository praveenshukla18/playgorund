package com.ps.covidportal.services;

import com.ps.covidportal.services.resultbeans.CovidTotalSummary;
import com.ps.covidportal.services.serviceHelpers.CovidSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/covidSummary")
public class CovidSummaryRestController {

    @Autowired
    private CovidSummaryService covidSummaryService;

    @GetMapping("/total")
    public Map<String, CovidTotalSummary> getTotalSummary(){
        return covidSummaryService.getTotalSummary();
    }

    @GetMapping("/total/{state}")
    public CovidTotalSummary getTotalSummaryForState(@PathVariable("state") String state){
        return covidSummaryService.getTotalSummaryForState(state);
    }
}
