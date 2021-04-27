package com.sgerodes.bowlinggame.services.impl;

import com.sgerodes.bowlinggame.models.game.BowlingGameModel;
import com.sgerodes.bowlinggame.models.game.FrameModel;
import com.sgerodes.bowlinggame.services.IPointsCalculationService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class PointsCalculationServiceTest {

    @Qualifier("pointsCalculationServicesV2")
    @Autowired
    protected IPointsCalculationService calculationService;

    @Test
    void validPoints() {
        Map<List<FrameModel>, Integer> tests2Expected = new HashMap<>();
        tests2Expected.put(Arrays.asList(new FrameModel(1,1), new FrameModel(1,1)), 4);
        tests2Expected.put(Arrays.asList(new FrameModel(1,2), new FrameModel(1,1), new FrameModel(2,3)), 10);
        // spare
        tests2Expected.put(Arrays.asList(new FrameModel(5,5), new FrameModel(1,1)), 13);
        tests2Expected.put(Arrays.asList(new FrameModel(5,5), new FrameModel(0,1)), 11);
        // strike
        tests2Expected.put(Arrays.asList(new FrameModel(10), new FrameModel(2,3)), 20);
        tests2Expected.put(Arrays.asList(new FrameModel(10), new FrameModel(2,0)), 14);
        tests2Expected.put(Arrays.asList(new FrameModel(10), new FrameModel(0,0)), 10);
        tests2Expected.put(Arrays.asList(new FrameModel(10), new FrameModel(10), new FrameModel(10)), 60);
        tests2Expected.put(Arrays.asList(new FrameModel(10), new FrameModel(10,10,10).last()), 60);
        tests2Expected.put(Arrays.asList(new FrameModel(10), new FrameModel(10), new FrameModel(10,10,10).last()), 90);
        tests2Expected.put(Arrays.asList(new FrameModel(10), new FrameModel(1,0), new FrameModel(3,3)), 18);
        // perfect game
        tests2Expected.put(Arrays.asList(
                new FrameModel(10),
                new FrameModel(10),
                new FrameModel(10),
                new FrameModel(10),
                new FrameModel(10),
                new FrameModel(10),
                new FrameModel(10),
                new FrameModel(10),
                new FrameModel(10),
                new FrameModel(10,10,10).last()), 300);


        tests2Expected.forEach((frames, expectedScore) -> assertEquals(expectedScore, calculationService.calculatePoints(new BowlingGameModel(frames))));
    }
}