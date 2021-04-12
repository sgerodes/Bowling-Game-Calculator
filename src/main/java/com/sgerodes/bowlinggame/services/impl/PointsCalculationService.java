package com.sgerodes.bowlinggame.services.impl;


import com.sgerodes.bowlinggame.models.BowlingGame;
import com.sgerodes.bowlinggame.models.Frame;
import com.sgerodes.bowlinggame.services.IPointsCalculationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class PointsCalculationService implements IPointsCalculationService {

    private static final Logger logger = LoggerFactory.getLogger(PointsCalculationService.class);

    @Override
    public int calculatePoints(BowlingGame game) {
        List<Frame> frames = game.getFrames();
        int overallScore = 0;
        LinkedList<Integer> strikes = new LinkedList<>(); // a Queue; add a "2" counter if a strike appears, remove by FIFO
        int spareCount = 0; // increment by 1 if a spare appears
        for (Frame curr : frames) {
            overallScore += curr.getOverallScore();
            if (!strikes.isEmpty()) {
                for (int i = 0; i < strikes.size(); ++i) {
                    for (int roll : curr.getRolls()) {
                        overallScore += roll;
                        strikes.set(i, strikes.get(i) - 1);
                        if (strikes.get(i) == 0) {
                            break;
                        }
                    }
                }
                if (strikes.getFirst() == 0) {
                    strikes.removeFirst();
                }
            }
            if (spareCount > 0) {
                overallScore += curr.getFirstRollScore();
                spareCount--;
            }

            if (curr.isSpare()) {
                spareCount++;
            }
            if (curr.isStrike()) {
                strikes.add(2);
            }

            // there was an ambiguity in the game calculation given the rules described in the task.
            // After a search in the web the following was found:
            // - The last frame DOES count for previous strikes as bonus points.
            // - The strikes/spares produced in the last frame does NOT produce bonus points. Last frame can produce a maximum of 30 points
            // A total of 300 (not 330) point could be achieved for a perfect game
            // source wikipedia https://en.wikipedia.org/wiki/Strike_(bowling)
            // if the code should be fully conform to the rules given in the task,
            // please uncomment the following section.

//            if (curr.isLast()){
//                // special case for last frame strikes and spares, because several strikes/spares could happen in ode frame
//                boolean firstRollIsStrike = curr.getFirstRollScore() == Frame.getPinsAmount();
//                if (firstRollIsStrike){
//                    overallScore += curr.getSecondRollScore() + curr.getThirdRollScore();
//                }
//                boolean secondRollIsStrictlySpare = !firstRollIsStrike && curr.getFirstRollScore() + curr.getSecondRollScore() == Frame.getPinsAmount();
//                boolean secondRollIsStrike = curr.getSecondRollScore() == Frame.getPinsAmount();
//                if (secondRollIsStrictlySpare || secondRollIsStrike){
//                    overallScore += curr.getThirdRollScore();
//                }
//            }
        }
        return overallScore;
    }
}
