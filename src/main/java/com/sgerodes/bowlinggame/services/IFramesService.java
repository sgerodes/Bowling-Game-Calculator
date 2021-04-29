package com.sgerodes.bowlinggame.services;

import com.sgerodes.bowlinggame.models.api.CalculationOutputModel;
import com.sgerodes.bowlinggame.models.api.FramesInputModel;
import com.sgerodes.bowlinggame.models.api.HistoryOutputModel;
import com.sgerodes.bowlinggame.models.db.HistoryPersistenceModel;

import java.util.List;

public interface IFramesService {
    public List<HistoryOutputModel> getAllHistoryOutput();

    List<HistoryPersistenceModel> getAllHistoryPersistence();

    public CalculationOutputModel calculatePoints(FramesInputModel framesInputModel);
    public void saveCalculation(FramesInputModel framesInputModel, CalculationOutputModel calculationOutputModel);
}
