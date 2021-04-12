package com.sgerodes.bowlinggame.services.impl;

import com.sgerodes.bowlinggame.exceptions.game.InvalidFrameException;
import com.sgerodes.bowlinggame.exceptions.game.InvalidGameException;
import com.sgerodes.bowlinggame.exceptions.game.InvalidInitialStateException;
import com.sgerodes.bowlinggame.models.BowlingGame;
import com.sgerodes.bowlinggame.models.Frame;
import com.sgerodes.bowlinggame.services.IGameValidator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameValidatorTest {

    IGameValidator gameValidator = new GameValidator();

    @Test
    void testValidator() {
        assertThrows(InvalidGameException.class, () -> gameValidator.validateGame(new BowlingGame(Arrays.asList(new Frame(1,2)))));

        BowlingGame game1 = getFullGame();
        game1.setFrame(1, new Frame(1,2,3));
        assertThrows(InvalidFrameException.class, () -> gameValidator.validateGame(game1));

        BowlingGame game2 = getFullGame();
        game2.setFrame(1, new Frame(7, 7));
        assertThrows(InvalidFrameException.class, () -> gameValidator.validateGame(game2));

        BowlingGame game3 = getFullGame();
        game3.setFrame(1, new Frame(10, 0));
        assertThrows(InvalidFrameException.class, () -> gameValidator.validateGame(game3));

        BowlingGame game4 = getFullGame();
        game4.setFrame(1, new Frame(-2, 3));
        assertThrows(InvalidFrameException.class, () -> gameValidator.validateGame(game4));
    }

    private BowlingGame getFullGame(){
        ArrayList<Frame> frames = new ArrayList<Frame>(){{
            add(new Frame(1, 2));
            add(new Frame(1, 2));
            add(new Frame(1, 2));
            add(new Frame(1, 2));
            add(new Frame(1, 2));
            add(new Frame(1, 2));
            add(new Frame(1, 2));
            add(new Frame(1, 2));
            add(new Frame(1, 2));
            add(new Frame(1, 2));
        }};
        return new BowlingGame(frames);
    }
}