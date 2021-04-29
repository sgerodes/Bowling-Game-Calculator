package com.sgerodes.bowlinggame.controllers;

import com.sgerodes.bowlinggame.models.api.CalculationOutputModel;
import com.sgerodes.bowlinggame.models.api.FramesInputModel;
import com.sgerodes.bowlinggame.models.api.HistoryOutputModel;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IBowlingCalculatorController {
    @ApiOperation(value = "Calculates the score of a bowling game for given frames")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 200, message = "OK")
    })
    CalculationOutputModel calculatePoints(@RequestBody FramesInputModel body);

    @ApiOperation(value = "Returns a list of all inputs with the calculated scores")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK")
    })
    List<HistoryOutputModel> getAllCalculations();
}
