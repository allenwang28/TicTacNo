package com.old.gameobjects;

/**
 * Created by allenwang on 7/26/15.
 *
 * Contains array of Tiles
 */
public class Board {
    private Tile board[][];
    public final int numTilesX = 4;
    public final int numTilesY = 4;
    private float xSize;
    private float ySize;
    private float xDisplacement;
    private float yDisplacement;
    private Possession possession = Possession.Player1;

    public Board(float xSize, float ySize, float xDisplacement, float yDisplacement) {
        this.xSize = xSize;
        this.ySize = ySize;
        this.xDisplacement = xDisplacement;
        this.yDisplacement = yDisplacement;
        board = new Tile[numTilesX][numTilesY];

        for (int x = 0; x < numTilesX; ++x) {
            for (int y = 0; y < numTilesY; ++y) {
                board[x][y] = new Tile(xSize, ySize);
                board[x][y].setPossession(Possession.None);
                board[x][y].setX(xDisplacement + x * xSize);
                board[x][y].setY(yDisplacement + y * ySize);
            }
        }
    }

    public void onClick(int x, int y) {
        // Find the tile corresponding to the click

        // Toggle Possession
        if (possession == Possession.Player1) {
            possession = Possession.Player2;
        } else {
            possession = Possession.Player2;
        }
    }

    public Tile[][] getBoard() {
        return board;
    }
}
