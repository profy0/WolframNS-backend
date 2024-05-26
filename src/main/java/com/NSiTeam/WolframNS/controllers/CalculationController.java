package com.NSiTeam.WolframNS.controllers;

import com.NSiTeam.WolframNS.libraries.MatrixOperations;
import com.NSiTeam.WolframNS.libraries.SimpleCalculations;
import com.NSiTeam.WolframNS.libraries.TrigonometryCalculator;
import com.NSiTeam.WolframNS.requests.CalculationRequest;
import com.NSiTeam.WolframNS.requests.ConversionRequest;
import com.NSiTeam.WolframNS.requests.MatrixRequest;
import com.NSiTeam.WolframNS.requests.TrigonometryRequest;
import com.NSiTeam.WolframNS.responses.CalculationResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import static com.NSiTeam.WolframNS.libraries.ConversionCalculator.convertBase;

@RestController
@Log
@RequiredArgsConstructor
@RequestMapping(path = "/calculation")
public class CalculationController {

    @Autowired
    private SimpleCalculations simpleCalculations;


    @PostMapping(path = "/simple")
    public CalculationResponse simpleCalculation(@RequestBody CalculationRequest calculationRequest) {

        log.severe(calculationRequest.getToCalc() + " - toCalc");



        return CalculationResponse.builder()
                .result(simpleCalculations.calculate(calculationRequest.getToCalc()))
                .build();
    }

    @PostMapping(path = "/matrix")
    public Map<String, double[][]> calculate(
            @RequestBody MatrixRequest payload
    ) {
        double[][] matrix1 = payload.getMatrix1AsArray();
        double[][] matrix2 = payload.getMatrix2AsArray();
        String operation = payload.getOperation();

        double[][] result = switch (operation) {
            case "add" -> MatrixOperations.add(matrix1, matrix2);
            case "multiply" -> MatrixOperations.multiply(matrix1, matrix2);
            case "transpose" -> MatrixOperations.transpose(matrix1);
            default -> throw new IllegalArgumentException("Invalid operation: " + operation);
        };

        return Map.of("result", result);
    }

    @PostMapping("/trigonometry")
    public Map<String, Double> calculateTrigonometry(
            @RequestBody TrigonometryRequest payload
    ) {
        double angle = payload.getAngle();
        int terms = payload.getTerms();

        double sinValue = TrigonometryCalculator.calculateSin(angle, terms);
        double cosValue = TrigonometryCalculator.calculateCos(angle, terms);

        Map<String, Double> result = new HashMap<>();

        result.put("sin", sinValue);
        result.put("cos", cosValue);

        return result;
    }

    @PostMapping("/conversion")
    public Map<String, String> convert(@RequestBody ConversionRequest request) {
        String result = convertBase(request.getNumber(), request.getFromBase(), request.getToBase());
        return Map.of("result", result);
    }



}
