package com.sgerodes.bowlinggame.controllers;

import com.sgerodes.bowlinggame.models.CalculationOutputModel;
import com.sgerodes.bowlinggame.models.FramesInputModel;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestBody;

public interface IBowlingCalculatorController {
    @ApiOperation(value = "Calculates the score of a bowling game for given frames")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 200, message = "OK")
    })
    CalculationOutputModel calculatePoints(@RequestBody FramesInputModel body);
}
