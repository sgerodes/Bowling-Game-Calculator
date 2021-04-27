package com.sgerodes.bowlinggame.services.impl;

import com.sgerodes.bowlinggame.models.game.BowlingGameModel;
import com.sgerodes.bowlinggame.models.game.FrameModel;
import com.sgerodes.bowlinggame.services.IPointsCalculationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointsCalculationServicesV2 implements IPointsCalculationService {

    private static final Logger logger = LoggerFactory.getLogger(PointsCalculationServicesV2.class);

    @Override
    public int calculatePoints(BowlingGameModel game) {
        logger.debug(String.format("Start calculating points of game: %s", game));
        List<FrameModel> frames = game.getFrames();
        int lastFrameIndex = frames.size()-1;
        int overallScore = frames.get(lastFrameIndex).getOverallScore();

        for (int i = lastFrameIndex-1; i >= 0;--i){
            FrameModel curr = frames.get(i);
            logger.trace(String.format("Calculating %s", curr));
            overallScore += curr.getOverallScore();
            logger.trace(String.format("Add frame base score: %s", curr.getOverallScore()));

            if (curr.isSpare() || curr.isStrike()) {
                logger.trace("Is spare or strike, Adding bonus for next roll");
                FrameModel next = frames.get(i+1);
                overallScore += next.getFirstRollScore();
                if (curr.isStrike()){
                    logger.trace("Is strike, Adding bonus for second next roll");
                    if (next.getSecondRoll() != null){
                        overallScore += next.getSecondRollScore();
                    } else {
                        if (frames.size() > i+2){
                            FrameModel nextNext = frames.get(i+2);
                            overallScore += nextNext.getFirstRollScore();
                        }
                    }
                }
            }
            logger.trace(String.format("Overall score after strike and spare bonus: %s", overallScore));
        }
        logger.info(String.format("Calculated points for the game: %s", overallScore));
        return overallScore;
    }
}
