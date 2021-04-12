package com.sgerodes.bowlinggame.models;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "Calculation response")
public class CalculationOutput {
    protected Integer overallPoints;

    public CalculationOutput(Integer points) {
        this.overallPoints = points;
    }

    public Integer getOverallPoints() {
        return overallPoints;
    }

    public void setOverallPoints(Integer overallPoints) {
        this.overallPoints = overallPoints;
    }
}
