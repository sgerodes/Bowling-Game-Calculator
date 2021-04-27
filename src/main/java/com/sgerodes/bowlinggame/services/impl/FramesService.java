package com.sgerodes.bowlinggame.services.impl;

import com.sgerodes.bowlinggame.models.api.CalculationOutputModel;
import com.sgerodes.bowlinggame.models.api.FramesInputModel;
import com.sgerodes.bowlinggame.models.db.CalculationPersistenceModel;
import com.sgerodes.bowlinggame.models.game.BowlingGameModel;
import com.sgerodes.bowlinggame.services.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FramesService implements IFramesService {

    private static final Logger logger = LoggerFactory.getLogger(FramesService.class);

    @Autowired
    protected CalculationRepository calculationRepository;

    @Autowired
    protected IJsonGameParser parser;

    @Autowired
    protected IGameValidator validator;

    @Qualifier("pointsCalculationServicesV2")
    @Autowired
    protected IPointsCalculationService calculationService;

    @Override
    public List<CalculationPersistenceModel> calculationsList() {
        List<CalculationPersistenceModel> result = new ArrayList<>();
        calculationRepository.findAll().forEach(result::add);
        logger.debug(String.format("Fetched %s calculated entries", result.size()));
        return result;
    }

    @Override
    public CalculationOutputModel calculatePoints(FramesInputModel framesInputModel) {
        BowlingGameModel game = parser.parseToBowlingGame(framesInputModel);
        validator.validateGame(game);
        int overallPoints = calculationService.calculatePoints(game);
        CalculationOutputModel outputModel = new CalculationOutputModel(overallPoints);
        saveCalculation(framesInputModel, outputModel);
        return outputModel;
    }

    @Override
    public void saveCalculation(FramesInputModel framesInputModel, CalculationOutputModel calculationOutputModel) {
        String repr = framesInputModel.getFrames().toString();
        int points = calculationOutputModel.getOverallPoints();
        CalculationPersistenceModel calculation = new CalculationPersistenceModel(repr, points);
        CalculationPersistenceModel save = calculationRepository.save(calculation);
        logger.debug(String.format("Calculation saved: %s", save));
    }
}
