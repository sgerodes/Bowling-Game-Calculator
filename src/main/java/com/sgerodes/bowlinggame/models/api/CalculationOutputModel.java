package com.sgerodes.bowlinggame.models.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Calculation response")
public class CalculationOutputModel {
    @ApiModelProperty(example = "114")
    protected Integer overallPoints;

    public CalculationOutputModel(Integer points) {
        this.overallPoints = points;
    }

    public Integer getOverallPoints() {
        return overallPoints;
    }

    public void setOverallPoints(Integer overallPoints) {
        this.overallPoints = overallPoints;
    }
}
