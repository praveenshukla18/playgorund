package com.ps.covidportal.services;

import com.ps.covidportal.services.resultbeans.CovidTotalSummary;
import com.ps.covidportal.services.serviceHelpers.CovidSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
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
