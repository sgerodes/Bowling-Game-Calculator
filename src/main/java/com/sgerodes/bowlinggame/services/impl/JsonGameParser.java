package com.sgerodes.bowlinggame.services.impl;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.sgerodes.bowlinggame.exceptions.http.InvalidRequestInputException;
import com.sgerodes.bowlinggame.models.BowlingGame;
import com.sgerodes.bowlinggame.models.Frame;
import com.sgerodes.bowlinggame.models.FramesInput;
import com.sgerodes.bowlinggame.services.IJsonGameParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JsonGameParser implements IJsonGameParser {

    private static final Logger logger = LoggerFactory.getLogger(JsonGameParser.class);
    Gson gson = new Gson();

    @Override
    public BowlingGame parseFromJson(String json) {
        // Json should be an object with a list of lists of integers
        // {
        //  "frames" : [[1,2],[4,3],[3,5]...]
        // }
        BowlingGame game = new BowlingGame();
        try {
            FramesInput parsed = gson.fromJson(json, FramesInput.class);
            for (List<Integer> parsedFrame : parsed.getFrames()) {
                Frame frame = new Frame(parsedFrame);
                if (parsedFrame == parsed.getFrames().get(parsed.getFrames().size() - 1)) {
                    frame.setLast(true);
                }
                game.addFrame(frame);
            }
        } catch (JsonSyntaxException e) {
            throw new InvalidRequestInputException("The provided body is an invalid");
        }
        return game;
    }
}
