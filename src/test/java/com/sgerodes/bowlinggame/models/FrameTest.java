package com.sgerodes.bowlinggame.models;

import com.sgerodes.bowlinggame.exceptions.game.InvalidFrameException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FrameTest {

    @Test
    void initTest() {

        assertFalse(new FrameModel(1).isLast());
        assertFalse(new FrameModel(Arrays.asList(1)).isLast());
        assertFalse(new FrameModel(1,2).isLast());
        assertFalse(new FrameModel(Arrays.asList(1, 2)).isLast());

        assertThrows(InvalidFrameException.class, () -> new FrameModel(Arrays.asList(1,2,3,4)));


    }

    @Test
    void scoreCalculationTest() {
        assertEquals(1, new FrameModel(1).getOverallScore());
        assertEquals(3, new FrameModel(1,2).getOverallScore());
        assertEquals(6, new FrameModel(1,2,3).last().getOverallScore());
    }

    @Test
    void spareAndStrikeTest() {
        assertFalse(new FrameModel(1).isSpare());
        assertFalse(new FrameModel(1,2).isSpare());
        assertFalse(new FrameModel(1).isStrike());
        assertFalse(new FrameModel(1,2).isStrike());
        assertFalse(new FrameModel(1,9).isStrike());

        assertTrue(new FrameModel(1,9).isSpare());
        assertTrue(new FrameModel(10).isStrike());
    }
}