package com.old.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.old.gameobjects.Board;
import com.old.gameobjects.GameHandler;
import com.old.gameobjects.Player;
import com.old.gameobjects.Possession;
import com.old.ttnhelpers.OrderedPair;

/**
 * Created by allenwang on 7/26/15.
 */
public class GameWorld {
    private Board board;
    private Player player1;
    private Player player2;
    private GameHandler controller;

    public GameWorld(float xSize, float ySize, float xDisplacement, float yDisplacement) {
        board = new Board(xSize, ySize, xDisplacement, yDisplacement);
        player1 = new Player(Possession.Player1);
        player2 = new Player(Possession.Player2);
        controller = new GameHandler(this);
    }

    public Board getBoard() {
        return board;
    }

    public Player getPlayer1() { return this.player1; }

    public Player getPlayer2() { return this.player2; }

    public void onClick(float x, float y) {
        board.onClick(x, y);
        controller.update(board.getLastPossession());
        checkWin();
    }

    private void checkWin() {
        if (board.isFull()) {
            int score1 = player1.getScore();
            int score2 = player2.getScore();
            if (score1 > score2) {
                player1.addWin();
            } else if (score1 < score2) {
                player2.addWin();
            }
            board.reset();
            player1.resetScore();
            player2.resetScore();
            controller.reset();
        }
    }
}