package com.sgerodes.bowlinggame.services.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JsonGameParserTest {

    JsonGameParser parser = new JsonGameParser();

    @Test
    void parseJson() {
        assertDoesNotThrow(() -> parser.parseFromJson(wrapFrames("[[1,2]]")));
        assertDoesNotThrow(() -> parser.parseFromJson(wrapFrames("[[1,2],[3,4]]")));
        assertDoesNotThrow(() -> parser.parseFromJson(wrapFrames("[[1,2],[3,4],[5,6,7]]")));
        assertDoesNotThrow(() -> parser.parseFromJson(wrapFrames("[[1,2],[3,4,5],[5,6,7]]")));
    }

    private String wrapFrames(String frames){
        return String.format("{\"frames\":%s}", frames);
    }
}