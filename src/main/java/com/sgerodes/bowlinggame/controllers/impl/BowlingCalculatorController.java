package com.sgerodes.bowlinggame.controllers.impl;

import com.sgerodes.bowlinggame.controllers.IBowlingCalculatorController;
import com.sgerodes.bowlinggame.exceptions.game.InvalidInitialStateException;
import com.sgerodes.bowlinggame.exceptions.http.InvalidRequestInputException;
import com.sgerodes.bowlinggame.models.db.CalculationPersistenceModel;
import com.sgerodes.bowlinggame.models.api.CalculationOutputModel;
import com.sgerodes.bowlinggame.models.api.FramesInputModel;
import com.sgerodes.bowlinggame.services.*;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BowlingCalculatorController implements IBowlingCalculatorController {

    private static final Logger logger = LoggerFactory.getLogger(BowlingCalculatorController.class);

    @Autowired
    protected IFramesService framesService;

    @Override
    @RequestMapping(value = "/calculate", method = RequestMethod.POST, produces = "application/json")
    public CalculationOutputModel calculatePoints(@RequestBody FramesInputModel body) {
        try {
            logger.debug(String.format("Input received: %s", body));
            return framesService.calculatePoints(body);
        } catch (InvalidInitialStateException e) {
            logger.error("Could not calculate points of the game", e);
            String message = e.getMessage();
            throw new InvalidRequestInputException(message);
        }
    }


    @Override
    @RequestMapping(value = "/calculations", method = RequestMethod.GET, produces = "application/json")
    public List<CalculationPersistenceModel> getAllCalculations() {
        return framesService.calculationsList();
    }
}
