package com.sgerodes.bowlinggame.services;

import com.sgerodes.bowlinggame.models.game.BowlingGameModel;
import com.sgerodes.bowlinggame.models.api.FramesInputModel;

public interface IJsonGameParser {
    public BowlingGameModel parseToBowlingGame(FramesInputModel input);
}
