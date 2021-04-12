package com.sgerodes.bowlinggame.models;

import com.sgerodes.bowlinggame.exceptions.game.InvalidFrameException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FrameTest {

    @Test
    void initTest() {

        assertFalse(new Frame(1).isLast());
        assertFalse(new Frame(Arrays.asList(1)).isLast());
        assertFalse(new Frame(1,2).isLast());
        assertFalse(new Frame(Arrays.asList(1, 2)).isLast());

        assertThrows(InvalidFrameException.class, () -> new Frame(Arrays.asList(1,2,3,4)));


    }

    @Test
    void scoreCalculationTest() {
        assertEquals(1, new Frame(1).getOverallScore());
        assertEquals(3, new Frame(1,2).getOverallScore());
        assertEquals(6, new Frame(1,2,3).last().getOverallScore());
    }

    @Test
    void spareAndStrikeTest() {
        assertFalse(new Frame(1).isSpare());
        assertFalse(new Frame(1,2).isSpare());
        assertFalse(new Frame(1).isStrike());
        assertFalse(new Frame(1,2).isStrike());
        assertFalse(new Frame(1,9).isStrike());

        assertTrue(new Frame(1,9).isSpare());
        assertTrue(new Frame(10).isStrike());
    }
}