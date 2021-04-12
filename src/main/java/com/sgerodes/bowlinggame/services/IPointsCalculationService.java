package com.sgerodes.bowlinggame.services;


import com.sgerodes.bowlinggame.models.BowlingGame;

public interface IPointsCalculationService {
    public int calculatePoints(BowlingGame game);
}
