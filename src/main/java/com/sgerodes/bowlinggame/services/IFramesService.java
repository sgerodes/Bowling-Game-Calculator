package com.sgerodes.bowlinggame.services;

import com.sgerodes.bowlinggame.models.api.CalculationOutputModel;
import com.sgerodes.bowlinggame.models.api.FramesInputModel;
import com.sgerodes.bowlinggame.models.db.CalculationPersistenceModel;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IFramesService {
    public List<CalculationPersistenceModel> calculationsList();
    public CalculationOutputModel calculatePoints(FramesInputModel framesInputModel);
    public void saveCalculation(FramesInputModel framesInputModel, CalculationOutputModel calculationOutputModel);
}
