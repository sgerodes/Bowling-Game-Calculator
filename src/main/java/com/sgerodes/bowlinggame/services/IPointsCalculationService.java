package com.sgerodes.bowlinggame.services;


import com.sgerodes.bowlinggame.models.game.BowlingGameModel;
import org.springframework.stereotype.Service;

public interface IPointsCalculationService {
    public int calculatePoints(BowlingGameModel game);
}
