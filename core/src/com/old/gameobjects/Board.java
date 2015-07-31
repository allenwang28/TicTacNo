package com.old.gameobjects;
import com.old.ttnhelpers.OrderedPair;
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
                int tileNumber = x + y * numTilesY;
                board[x][y] = new Tile(tileNumber, xSize, ySize);
                board[x][y].setPossession(Possession.None);
                float xPosition = xDisplacement + x * xSize;
                float yPosition = yDisplacement + y * ySize;
                board[x][y].setPosition(new com.old.ttnhelpers.OrderedPair<Float, Float>(xPosition, yPosition));
            }
        }
    }

    public void reset() {
        for (Tile[] row: board) {
            for (Tile tile: row) {
                tile.setPossession(Possession.None);
            }
        }
    }

    public void onClick(float x, float y) {
        // Find the tile corresponding to the click
        for (Tile[] row: board) {
            for (Tile tile: row) {
                if (tile.isInRange(x,y)) {
                    if (tile.hasNoPossession()) {
                        tile.setPossession(possession);
                        this.possession = togglePossession();
                        break;
                    }
                }
            }
        }
   }

    private Possession togglePossession() {
        if (possession == Possession.Player1) {
            return Possession.Player2;
        } else {
            return Possession.Player1;
        }
    }

    public Tile[][] getBoard() {
        return board;
    }

    public boolean isFull() {
        for (Tile[] row: board) {
            for (Tile tile: row) {
                if (tile.getPossession() == Possession.None) {
                    return false;
                }
            }
        }
        return true;
    }

    public Tile getTile(int tileNum) {
        return board[tileNum % 4][tileNum / 4];
    }

    public Possession getLastPossession() {
        return togglePossession();
    }
}
