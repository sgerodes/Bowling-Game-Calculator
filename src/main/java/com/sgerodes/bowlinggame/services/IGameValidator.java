package com.sgerodes.bowlinggame.services;

import com.sgerodes.bowlinggame.models.game.BowlingGameModel;
import org.springframework.stereotype.Service;

public interface IGameValidator {
    public void validateGame(BowlingGameModel game);
}
