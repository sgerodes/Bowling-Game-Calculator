package com.sgerodes.bowlinggame.models.db;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class HistoryPersistenceModel {

    @Id
    @GeneratedValue
    protected Long id;
    protected String initialInput;
    protected Integer overallPoints;

    public HistoryPersistenceModel(String initialInput, Integer overallPoints) {
        this.initialInput = initialInput;
        this.overallPoints = overallPoints;
    }

    public HistoryPersistenceModel() {

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
        return "HistoryPersistenceModel{" +
                "id=" + id +
                ", initialInput='" + initialInput + '\'' +
                ", overallPoints=" + overallPoints +
                '}';
    }
}
