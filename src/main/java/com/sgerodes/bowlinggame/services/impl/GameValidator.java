package com.sgerodes.bowlinggame.services.impl;

import com.sgerodes.bowlinggame.exceptions.game.InvalidFrameException;
import com.sgerodes.bowlinggame.exceptions.game.InvalidGameException;
import com.sgerodes.bowlinggame.models.game.BowlingGameModel;
import com.sgerodes.bowlinggame.models.game.FrameModel;
import com.sgerodes.bowlinggame.services.IGameValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GameValidator implements IGameValidator {

    private static final Logger logger = LoggerFactory.getLogger(GameValidator.class);

    @Override
    public void validateGame(BowlingGameModel game) {
        logger.debug(String.format("Validating game: %s", game));
        //should have Correct amount of frames
        if (game.getFrames().size() != BowlingGameModel.getFramesAmount()) {
            throw new InvalidGameException(String.format("The game expected %s frames, got %s", BowlingGameModel.getFramesAmount(), game.getFrames().size()));
        }
        logger.debug("Game has correct amount of frames");
        // each frame should have correct amount of rolls
        game.getFrames().forEach(
                frame -> {
                    int maxRolls = frame.isLast() ? 3 : 2;
                    int minRolls = 1;
                    if (frame.getRollsCount() > maxRolls || frame.getRollsCount() < minRolls) {
                        throw new InvalidFrameException(String.format("Invalid amount of rolls in the frame %s. Expected to be between (inclusive) %s and %s. Got %s", frame, minRolls, maxRolls, frame.getRollsCount()));
                    }
                }
        );
        logger.debug("Each frame has correct amount of rolls");
        // only the last one should be marked as last
        for (int i = 0; i < game.getFrames().size(); i++) {
            if (i != game.getFrames().size() - 1 && game.getFrame(i).isLast()) {
                throw new InvalidFrameException("A not last frame is marked as last");
            }
            if (i == game.getFrames().size() - 1 && !game.getFrame(i).isLast()) {
                throw new InvalidFrameException("Last frame is not marked last");
            }
        }
        logger.debug("The 'last' flag is set correct");
        // each frame should have correct max and min amount of pins impacted
        game.getFrames().forEach(frame -> {
            frame.getRolls().forEach(roll -> {
                if (roll < 0 || roll > 10) {
                    throw new InvalidFrameException(String.format("Invalid roll in the frame %s. Expected to be between (inclusive) %s and %s. Got %s", frame, 0, 10, roll));
                }
            });
            int frameMaxScore = frame.isLast() ? 30 : 10;
            if (frame.getOverallScore() > frameMaxScore) {
                throw new InvalidFrameException(String.format("Invalid frame %s. Sum of pins impacted expected to be between (inclusive) %s and %s. Got %s", frame, 0, frameMaxScore, frame.getOverallScore()));
            }
        });
        logger.debug("Each frame has valid range of pins impacted");
        // if strike then should have only one roll
        game.getFrames().forEach(frame -> {
            if (frame.getFirstRollScore() == 10) {
                if (frame.getSecondRoll() != null && !frame.isLast()) {
                    throw new InvalidFrameException(String.format("In a strike frame there should be only one roll, got %s", frame));
                }
            }
        });
        logger.debug("Strike shots have valid structure");
        // last frame: allow third roll only if it is a strike or spare
        FrameModel lastFrame = game.getLastFrame();
        if (lastFrame.getThirdRoll() != null) {
            boolean lastIsStrikeOrSpare = lastFrame.getFirstRollScore() + lastFrame.getSecondRollScore() >= FrameModel.getPinsAmount();
            if (!lastIsStrikeOrSpare) {
                throw new InvalidFrameException(String.format("Last frame third roll is only allowed if at least one spare or strike was performed in the first two rolls. Got %s", lastFrame.getRolls()));
            }
        }
        logger.debug("Third roll rule is respected");
        logger.info("Game is valid");
    }
}
