package com.sgerodes.bowlinggame.services.impl;

import com.sgerodes.bowlinggame.exceptions.http.InvalidRequestInputException;
import com.sgerodes.bowlinggame.models.BowlingGameModel;
import com.sgerodes.bowlinggame.models.FrameModel;
import com.sgerodes.bowlinggame.models.FramesInputModel;
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
        BowlingGameModel game = new BowlingGameModel();
            for (List<Integer> parsedFrame : input.getFrames()) {
                FrameModel frame = new FrameModel(parsedFrame);
                if (parsedFrame == input.getFrames().get(input.getFrames().size() - 1)) {
                    frame.setLast(true);
                }
                game.addFrame(frame);
            }
        return game;
    }
}
