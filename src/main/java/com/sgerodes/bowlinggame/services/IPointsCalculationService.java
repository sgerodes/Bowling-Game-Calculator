package com.sgerodes.bowlinggame.services;


import com.sgerodes.bowlinggame.models.BowlingGameModel;

public interface IPointsCalculationService {
    public int calculatePoints(BowlingGameModel game);
}
