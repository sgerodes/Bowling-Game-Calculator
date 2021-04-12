package com.sgerodes.bowlinggame.controllers;

import com.sgerodes.bowlinggame.models.CalculationOutput;
import com.sgerodes.bowlinggame.models.FramesInput;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

public interface IBowlingCalculatorController {
    @ApiOperation(value = "Calculates the score of a bowling game for given frames")
    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "body2",
                    dataTypeClass = FramesInput.class,
                    examples = @Example(
                            value = {
                                    @ExampleProperty(
                                            value = "{\"frames\" : [[10], [7,3], [3,5], [0,7], [10], [3,4], [9,0], [5,1], [8,1], [3,7,8]]}",
                                            mediaType = "application/json")
                            }))
    })
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Not Found",
                    examples = @Example(
                            value = {
                                    @ExampleProperty(
                                            mediaType = "Example json",
                                            value = "{\"invalidField\": \"address\"}"),
                                    @ExampleProperty(
                                            mediaType = "Example string",
                                            value = "The first name was invalid")}),
                    response = CalculationOutput.class)})
    CalculationOutput calculatePoints(@RequestBody String body);
}
