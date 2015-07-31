package com.old.gameobjects;

import java.util.ArrayList;

/**
 * Created by allenwang on 7/28/15.
 */
public class Player {
    private int score;
    private Possession possession;

    public Player(Possession possession) {
        this.possession = possession;
        score = 0;
    }

    public void addPoints(int score) { this.score += score; }

    public int getScore() {
        return this.score;
    }
}
