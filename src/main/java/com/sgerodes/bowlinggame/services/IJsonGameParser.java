package com.sgerodes.bowlinggame.services;

import com.sgerodes.bowlinggame.models.BowlingGame;

public interface IJsonGameParser {
    public BowlingGame parseFromJson(String json);
}
