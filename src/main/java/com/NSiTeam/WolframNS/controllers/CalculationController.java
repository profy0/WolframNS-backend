package com.NSiTeam.WolframNS.controllers;

import com.NSiTeam.WolframNS.libraries.SimpleCalculations;
import com.NSiTeam.WolframNS.requests.CalculationRequest;
import com.NSiTeam.WolframNS.responses.CalculationResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Log
@RequiredArgsConstructor
public class CalculationController {

    @Autowired
    private SimpleCalculations simpleCalculations;

    @PostMapping(path = "/calculation")
    public CalculationResponse simpleCalculation(@RequestBody CalculationRequest calculationRequest) {

        log.severe(calculationRequest.getToCalc() + " - toCalc");



        return CalculationResponse.builder()
                .result(simpleCalculations.calculate(calculationRequest.getToCalc()))
                .build();
    }

}
