package com.sgerodes.bowlinggame.models.db;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@ApiModel(value = "Stored calculation")
public class CalculationPersistenceModel {

    @Id
    @GeneratedValue
    protected Long id;
    @ApiModelProperty(example = "[[1, 2], [3, 4], [3, 4], [3, 4], [3, 4], [3, 4], [3, 4], [3, 4], [3, 4], [3, 7, 6]]")
    protected String initialInput;
    @ApiModelProperty(example = "75")
    protected Integer overallPoints;

    public CalculationPersistenceModel(String initialInput, Integer overallPoints) {
        this.initialInput = initialInput;
        this.overallPoints = overallPoints;
    }

    public CalculationPersistenceModel() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInitialInput() {
        return initialInput;
    }

    public void setInitialInput(String initialInput) {
        this.initialInput = initialInput;
    }

    public Integer getOverallPoints() {
        return overallPoints;
    }

    public void setOverallPoints(Integer overallPoints) {
        this.overallPoints = overallPoints;
    }

    @Override
    public String toString() {
        return "CalculationPersistenceModel{" +
                "id=" + id +
                ", initialInput='" + initialInput + '\'' +
                ", overallPoints=" + overallPoints +
                '}';
    }
}
