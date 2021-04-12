package com.sgerodes.bowlinggame.controllers.impl;

import com.sgerodes.bowlinggame.controllers.IBowlingCalculatorController;
import com.sgerodes.bowlinggame.exceptions.game.InvalidInitialStateException;
import com.sgerodes.bowlinggame.exceptions.http.InvalidRequestInputException;
import com.sgerodes.bowlinggame.models.BowlingGameModel;
import com.sgerodes.bowlinggame.models.CalculationOutputModel;
import com.sgerodes.bowlinggame.models.FramesInputModel;
import com.sgerodes.bowlinggame.services.IGameValidator;
import com.sgerodes.bowlinggame.services.IJsonGameParser;
import com.sgerodes.bowlinggame.services.IPointsCalculationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BowlingCalculatorController implements IBowlingCalculatorController {

    private static final Logger logger = LoggerFactory.getLogger(BowlingCalculatorController.class);

    @Autowired
    protected IJsonGameParser parser;

    @Autowired
    protected IGameValidator validator;

    @Autowired
    protected IPointsCalculationService calculationService;

    @Override
    @RequestMapping(value = "/calculate", method = RequestMethod.POST, produces = "application/json")
    public CalculationOutputModel calculatePoints(@RequestBody FramesInputModel body) {
        try {
            BowlingGameModel game = parser.parseToBowlingGame(body);
            validator.validateGame(game);
            int overallPoints = calculationService.calculatePoints(game);
            return new CalculationOutputModel(overallPoints);
        } catch (InvalidInitialStateException e) {
            logger.error("Could not calculate points of the game", e);
            String message = e.getMessage();
            throw new InvalidRequestInputException(message);
        }
    }
}
