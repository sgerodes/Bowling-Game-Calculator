package com.sgerodes.bowlinggame.services.impl;

import com.sgerodes.bowlinggame.models.game.BowlingGameModel;
import com.sgerodes.bowlinggame.models.game.FrameModel;
import com.sgerodes.bowlinggame.models.api.FramesInputModel;
import com.sgerodes.bowlinggame.services.IJsonGameParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JsonGameParser implements IJsonGameParser {

    private static final Logger logger = LoggerFactory.getLogger(JsonGameParser.class);

    @Override
    public BowlingGameModel parseToBowlingGame(FramesInputModel input) {
        logger.debug(String.format("Start parsing: %s", input));
        BowlingGameModel game = new BowlingGameModel();
            for (List<Integer> parsedFrame : input.getFrames()) {
                FrameModel frame = new FrameModel(parsedFrame);
                if (parsedFrame == input.getFrames().get(input.getFrames().size() - 1)) {
                    frame.setLast(true);
                }
                game.addFrame(frame);
            }
        logger.debug(String.format("Parsed to game: %s", game));
        return game;
    }
}
