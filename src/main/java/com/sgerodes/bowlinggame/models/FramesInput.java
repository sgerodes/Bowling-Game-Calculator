package com.sgerodes.bowlinggame.models;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class FramesInput {
    @ApiModelProperty(required = true, example = "Timeout exceeded")
    protected List<List<Integer>> frames;

    public List<List<Integer>> getFrames() {
        return frames;
    }

    public void setFrames(List<List<Integer>> frames) {
        this.frames = frames;
    }
}
