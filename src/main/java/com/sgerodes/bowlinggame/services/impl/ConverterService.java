package com.sgerodes.bowlinggame.services.impl;

import com.sgerodes.bowlinggame.models.api.HistoryOutputModel;
import com.sgerodes.bowlinggame.models.db.HistoryPersistenceModel;
import com.sgerodes.bowlinggame.models.game.BowlingGameModel;
import com.sgerodes.bowlinggame.models.game.FrameModel;
import com.sgerodes.bowlinggame.models.api.FramesInputModel;
import com.sgerodes.bowlinggame.services.IConverterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConverterService implements IConverterService {

    private static final Logger logger = LoggerFactory.getLogger(ConverterService.class);

    @Override
    public BowlingGameModel framesInput2BowlingGame(FramesInputModel spurce) {
        logger.debug(String.format("Start parsing: %s", spurce));
        BowlingGameModel target = new BowlingGameModel();
            for (List<Integer> parsedFrame : spurce.getFrames()) {
                FrameModel frame = new FrameModel(parsedFrame);
                if (parsedFrame == spurce.getFrames().get(spurce.getFrames().size() - 1)) {
                    frame.setLast(true);
                }
                target.addFrame(frame);
            }
        logger.debug(String.format("Parsed to game: %s", target));
        return target;
    }

    @Override
    public HistoryOutputModel historyPersistence2HistoryOutput(HistoryPersistenceModel source){
        HistoryOutputModel target = new HistoryOutputModel();
        target.setId(source.getId());
        target.setInitialInput(source.getInitialInput());
        target.setOverallPoints(source.getOverallPoints());
        return target;
    }
}
