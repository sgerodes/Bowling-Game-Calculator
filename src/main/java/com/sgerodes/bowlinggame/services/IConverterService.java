package com.sgerodes.bowlinggame.services;

import com.sgerodes.bowlinggame.models.api.HistoryOutputModel;
import com.sgerodes.bowlinggame.models.db.HistoryPersistenceModel;
import com.sgerodes.bowlinggame.models.game.BowlingGameModel;
import com.sgerodes.bowlinggame.models.api.FramesInputModel;

public interface IConverterService {
    BowlingGameModel framesInput2BowlingGame(FramesInputModel input);

    HistoryOutputModel historyPersistence2HistoryOutput(HistoryPersistenceModel source);
}
