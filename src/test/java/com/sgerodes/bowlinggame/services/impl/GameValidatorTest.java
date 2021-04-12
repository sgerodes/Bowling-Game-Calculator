package com.sgerodes.bowlinggame.services.impl;

import com.sgerodes.bowlinggame.exceptions.game.InvalidFrameException;
import com.sgerodes.bowlinggame.exceptions.game.InvalidGameException;
import com.sgerodes.bowlinggame.models.BowlingGameModel;
import com.sgerodes.bowlinggame.models.FrameModel;
import com.sgerodes.bowlinggame.services.IGameValidator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GameValidatorTest {

    IGameValidator gameValidator = new GameValidator();

    @Test
    void testValidator() {
        assertThrows(InvalidGameException.class, () -> gameValidator.validateGame(new BowlingGameModel(Arrays.asList(new FrameModel(1,2)))));

        BowlingGameModel game1 = getFullGame();
        game1.setFrame(1, new FrameModel(1,2,3));
        assertThrows(InvalidFrameException.class, () -> gameValidator.validateGame(game1));

        BowlingGameModel game2 = getFullGame();
        game2.setFrame(1, new FrameModel(7, 7));
        assertThrows(InvalidFrameException.class, () -> gameValidator.validateGame(game2));

        BowlingGameModel game3 = getFullGame();
        game3.setFrame(1, new FrameModel(10, 0));
        assertThrows(InvalidFrameException.class, () -> gameValidator.validateGame(game3));

        BowlingGameModel game4 = getFullGame();
        game4.setFrame(1, new FrameModel(-2, 3));
        assertThrows(InvalidFrameException.class, () -> gameValidator.validateGame(game4));
    }

    private BowlingGameModel getFullGame(){
        ArrayList<FrameModel> frames = new ArrayList<FrameModel>(){{
            add(new FrameModel(1, 2));
            add(new FrameModel(1, 2));
            add(new FrameModel(1, 2));
            add(new FrameModel(1, 2));
            add(new FrameModel(1, 2));
            add(new FrameModel(1, 2));
            add(new FrameModel(1, 2));
            add(new FrameModel(1, 2));
            add(new FrameModel(1, 2));
            add(new FrameModel(1, 2));
        }};
        return new BowlingGameModel(frames);
    }
}