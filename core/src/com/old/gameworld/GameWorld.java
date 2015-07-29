package com.old.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.old.gameobjects.Board;

/**
 * Created by allenwang on 7/26/15.
 */
public class GameWorld {

    private Board board;


    public GameWorld(float xSize, float ySize, float xDisplacement, float yDisplacement) {
        board = new Board(xSize, ySize, xDisplacement, yDisplacement);
    }

    public void update(float delta) {
        Gdx.app.log("GameWorld", "Update");
    }

    public Board getBoard() {
        return board;
    }

}
