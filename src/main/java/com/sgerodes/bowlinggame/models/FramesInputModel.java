package com.sgerodes.bowlinggame.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

@ApiModel
public class FramesInputModel {
    @ApiModelProperty(value = "frames", example = "[[10], [7,3], [3,5], [0,7], [10], [3,4], [9,0], [5,1], [8,1], [3,7,8]]")
    protected List<List<Integer>> frames;

    public FramesInputModel() {
        this.frames = new ArrayList<>();
    }

    public FramesInputModel(List<List<Integer>> frames) {
        this.frames = frames;
    }

    public List<List<Integer>> getFrames() {
        return frames;
    }

    public void setFrames(List<List<Integer>> frames) {
        this.frames = frames;
    }
}
