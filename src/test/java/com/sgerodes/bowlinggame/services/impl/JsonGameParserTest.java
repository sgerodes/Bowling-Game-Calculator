package com.sgerodes.bowlinggame.services.impl;

import com.sgerodes.bowlinggame.models.api.FramesInputModel;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class JsonGameParserTest {

    JsonGameParser parser = new JsonGameParser();

    @Test
    void parseJson() {
        assertDoesNotThrow(() -> parser.parseToBowlingGame(createDefaultFrame()));

        FramesInputModel input2 = createDefaultFrame();
        input2.getFrames().add(getDefaultFrame(false));
        assertDoesNotThrow(() -> parser.parseToBowlingGame(input2));

        FramesInputModel input3 = createDefaultFrame();
        input3.getFrames().add(getDefaultFrame(false));
        input3.getFrames().add(getDefaultFrame(true));
        assertDoesNotThrow(() -> parser.parseToBowlingGame(input3));

        FramesInputModel input4 = createDefaultFrame();
        input4.getFrames().add(getDefaultFrame(false));
        input4.getFrames().add(getDefaultFrame(true));
        input4.getFrames().add(getDefaultFrame(true));
        assertDoesNotThrow(() -> parser.parseToBowlingGame(input4));
    }

    private String wrapFrames(String frames){
        return String.format("{\"frames\":%s}", frames);
    }

    private FramesInputModel createDefaultFrame(){
        FramesInputModel input = new FramesInputModel();
        input.getFrames().add(getDefaultFrame(false));
        return input;
    }

    private ArrayList<Integer> getDefaultFrame(boolean isLast){
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        if (isLast){
            integers.add(3);
        }
        return integers;
    }
}