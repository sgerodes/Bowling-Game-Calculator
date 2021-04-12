package com.sgerodes.bowlinggame.services.impl;

import com.sgerodes.bowlinggame.models.BowlingGame;
import com.sgerodes.bowlinggame.models.Frame;
import com.sgerodes.bowlinggame.services.IPointsCalculationService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PointsCalculationServiceTest {

    IPointsCalculationService calculationService = new PointsCalculationService();

    @Test
    void validPoints() {
        Map<List<Frame>, Integer> tests2Expected = new HashMap<>();
        tests2Expected.put(Arrays.asList(new Frame(1,1), new Frame(1,1)), 4);
        tests2Expected.put(Arrays.asList(new Frame(1,2), new Frame(1,1), new Frame(2,3)), 10);
        // spare
        tests2Expected.put(Arrays.asList(new Frame(5,5), new Frame(1,1)), 13);
        tests2Expected.put(Arrays.asList(new Frame(5,5), new Frame(0,1)), 11);
        // strike
        tests2Expected.put(Arrays.asList(new Frame(10), new Frame(2,3)), 20);
        tests2Expected.put(Arrays.asList(new Frame(10), new Frame(2,0)), 14);
        tests2Expected.put(Arrays.asList(new Frame(10), new Frame(0,0)), 10);
        tests2Expected.put(Arrays.asList(new Frame(10), new Frame(10), new Frame(10)), 60);
        tests2Expected.put(Arrays.asList(new Frame(10), new Frame(10,10,10).last()), 60);
        tests2Expected.put(Arrays.asList(new Frame(10), new Frame(10), new Frame(10,10,10).last()), 90);
        tests2Expected.put(Arrays.asList(new Frame(10), new Frame(1,0), new Frame(3,3)), 18);
        // perfect game
        tests2Expected.put(Arrays.asList(
                new Frame(10),
                new Frame(10),
                new Frame(10),
                new Frame(10),
                new Frame(10),
                new Frame(10),
                new Frame(10),
                new Frame(10),
                new Frame(10),
                new Frame(10,10,10).last()), 300);


        tests2Expected.forEach((frames, expectedScore) -> assertEquals(expectedScore, calculationService.calculatePoints(new BowlingGame(frames))));
    }
}