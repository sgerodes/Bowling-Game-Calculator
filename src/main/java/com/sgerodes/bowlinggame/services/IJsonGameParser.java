package com.sgerodes.bowlinggame.services;

import com.sgerodes.bowlinggame.models.BowlingGameModel;
import com.sgerodes.bowlinggame.models.FramesInputModel;

public interface IJsonGameParser {
    public BowlingGameModel parseToBowlingGame(FramesInputModel input);
}
