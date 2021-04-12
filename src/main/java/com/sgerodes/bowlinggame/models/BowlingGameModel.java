package com.sgerodes.bowlinggame.models;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class BowlingGameModel {
    static int FRAMES_AMOUNT = 10;

    private static final Logger logger = LoggerFactory.getLogger(BowlingGameModel.class);

    protected List<FrameModel> frames;

    public BowlingGameModel() {
        this.frames = new ArrayList<>();
    }

    public BowlingGameModel(List<FrameModel> frames) {
        this.frames = frames;
    }

    public void addFrame(FrameModel frame) {
        this.frames.add(frame);
    }

    public List<FrameModel> getFrames() {
        return frames;
    }

    public void setFrames(List<FrameModel> frames) {
        this.frames = frames;
    }

    public FrameModel getFrame(int n) {
        return this.frames.get(n);
    }

    public FrameModel getLastFrame() {
        return this.frames.get(this.frames.size() - 1);
    }

    public void setFrame(int i, FrameModel frame) {
        this.frames.set(i, frame);
    }


    public static int getFramesAmount() {
        return FRAMES_AMOUNT;
    }

    @Override
    public String toString() {
        return "BowlingGame{" +
                "frames=" + frames +
                '}';
    }
}
