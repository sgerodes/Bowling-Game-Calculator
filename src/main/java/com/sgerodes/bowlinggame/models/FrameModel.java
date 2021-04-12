package com.sgerodes.bowlinggame.models;


import com.sgerodes.bowlinggame.exceptions.game.InvalidFrameException;

import java.util.Arrays;
import java.util.List;

public class FrameModel {
    static int PINS_AMOUNT = 10;
    static int MAX_AMOUNT_OF_ROLLS = 3;

    // the list can have up to 3 rolls. If a non existing roll is accessed a null is returned
    protected List<Integer> rolls;
    protected boolean last;


    public FrameModel() {
        this.last = false;
    }

    public FrameModel(Integer firstRoll) {
        this.last = false;
        rolls = Arrays.asList(firstRoll);
    }


    public FrameModel(Integer firstRoll, Integer secondRoll) {
        this.last = false;
        rolls = Arrays.asList(firstRoll, secondRoll);
    }

    public FrameModel(Integer firstRoll, Integer secondRoll, Integer thirdRoll) {
        this.last = false;
        rolls = Arrays.asList(firstRoll, secondRoll, thirdRoll);
    }

    public FrameModel(List<Integer> rolls) {
        this.last = false;
        if (rolls.size() > MAX_AMOUNT_OF_ROLLS) {
            throw new InvalidFrameException(String.format("A frame can have a maximum amount of %s rolls, but %s was provided", MAX_AMOUNT_OF_ROLLS, rolls.size()));
        }
        this.rolls = rolls;
    }

    public Integer getFirstRoll() {
        return rolls.size() >= 1 ? rolls.get(0) : null;
    }

    public Integer getSecondRoll() {
        return rolls.size() >= 2 ? rolls.get(1) : null;
    }

    public Integer getThirdRoll() {
        return rolls.size() >= 3 ? rolls.get(2) : null;
    }

    public Integer getRoll(int n) {
        // zero indexed
        return rolls.size() >= n ? rolls.get(n) : null;
    }

    public List<Integer> getRolls() {
        return rolls;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public FrameModel last() {
        this.setLast(true);
        return this; // for better initialization e.g. new Frame().last()
    }

    public boolean isSpare() {
        return getFirstRoll() != null && getSecondRoll() != null && getFirstRollScore() + getSecondRollScore() == getPinsAmount();
    }

    public boolean isStrike() {
        return getFirstRoll() != null && getFirstRollScore() == getPinsAmount();
    }

    public int getRollsCount() {
        return this.rolls.size();
    }

    public int getOverallScore() {
        return isLast() ? getFirstRollScore() + getSecondRollScore() + getThirdRollScore() : getFirstRollScore() + getSecondRollScore();
    }

    public Integer getFirstRollScore() {
        return getFirstRoll() != null ? getFirstRoll() : 0;
    }

    public Integer getSecondRollScore() {
        return getSecondRoll() != null ? getSecondRoll() : 0;
    }

    public Integer getThirdRollScore() {
        return getThirdRoll() != null ? getThirdRoll() : 0;
    }

    public static int getPinsAmount() {
        return PINS_AMOUNT;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Frame{");
        sb.append(rolls);
        if (last) {
            sb.append(", last=true");
        }
        sb.append("}");
        return sb.toString();
    }
}
