package com.sgerodes.bowlinggame.models;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    static int FRAMES_AMOUNT = 10;

    private static final Logger logger = LoggerFactory.getLogger(BowlingGame.class);

    protected List<Frame> frames;

    public BowlingGame() {
        this.frames = new ArrayList<>();
    }

    public BowlingGame(List<Frame> frames) {
        this.frames = frames;
    }

    public void addFrame(Frame frame) {
        this.frames.add(frame);
    }

    public List<Frame> getFrames() {
        return frames;
    }

    public void setFrames(List<Frame> frames) {
        this.frames = frames;
    }

    public Frame getFrame(int n) {
        return this.frames.get(n);
    }

    public Frame getLastFrame() {
        return this.frames.get(this.frames.size() - 1);
    }

    public void setFrame(int i, Frame frame) {
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
