package com.old.gameobjects;

import com.old.gameworld.GameWorld;
import com.old.ttnhelpers.OrderedPair;
import com.old.ttnhelpers.ScoringSequence;
import com.old.ttnhelpers.ScoringSequenceList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by allenwang on 7/29/15.
 */
enum Direction { up, upright, right, downright, down, downleft, left, upleft }

public class GameHandler {
    private GameWorld world;
    private Player player1;
    private Player player2;
    private Board board;
    private ArrayList<ArrayList<Integer>> scoredTiles;
    private final Direction directions[] = Direction.values();

    private final ScoringSequence seq1 = new ScoringSequence(ScoringSequence.scoringSequence1, 1);
    private final ScoringSequence seq2 = new ScoringSequence(ScoringSequence.scoringSequence2, 1);
    private final ScoringSequence seq3 = new ScoringSequence(ScoringSequence.scoringSequence3, 2);
    private final ScoringSequence seq4 = new ScoringSequence(ScoringSequence.scoringSequence4, 2);

    private final ScoringSequenceList seqList = new ScoringSequenceList(seq1, seq2, seq3, seq4);


    public GameHandler(GameWorld world) {
        this.world = world;
        this.player1 = world.getPlayer1();
        this.player2 = world.getPlayer2();
        this.board = world.getBoard();
        scoredTiles = new ArrayList(new ArrayList());
    }

    public void reset() {
        scoredTiles.clear();
    }

    public void update(Possession lastMove) {
        for (Tile[] tilerow : board.getBoard()) {
            for (Tile tile: tilerow) {
                if (!tile.hasNoPossession()) {
                    for (Direction dir : directions) {
                        check(dir, tile, lastMove);
                    }
                }
            }
        }
    }

    private boolean canGo(Direction dir, int tileNum) {
        int column = tileNum % 4;
        final boolean canGoUp = (tileNum < 12);
        final boolean canGoDown = (tileNum > 3);
        final boolean canGoRight = (column != 3);
        final boolean canGoLeft = (column != 0);
        switch (dir) {
            case up:
                return canGoUp;
            case upright:
                return canGoRight && canGoUp;
            case right:
                return canGoRight;
            case downright:
                return canGoRight && canGoDown;
            case down:
                return canGoDown;
            case downleft:
                return canGoDown && canGoLeft;
            case left:
                return canGoLeft;
            case upleft:
                return canGoUp && canGoLeft;
            default:
                return false;
        }
    }

    private int go(Direction dir, int tileNum) {
        switch(dir) {
            case down:
                return tileNum - 4;
            case downright:
                return tileNum - 3;
            case right:
                return tileNum + 1;
            case upright:
                return tileNum + 5;
            case up:
                return tileNum + 4;
            case upleft:
                return tileNum + 3;
            case left:
                return tileNum - 1;
            case downleft:
                return tileNum - 5;
            default:
                return 0;   // Should never reach this case
        }
    }

    private void check(Direction dir, Tile tile, Possession lastPossession) {
        Tile thisTile = tile;   // TODO - check this: It might get a little funky.
        int tileNum = thisTile.getNumber();
        ArrayList<Possession> p = new ArrayList();
        ArrayList<Integer> positions = new ArrayList(tileNum);
        p.add(tile.getPossession());
        positions.add(tileNum);
        while (canGo(dir, tileNum)) {
            tileNum = go(dir, tileNum);
            thisTile = board.getTile(tileNum);
            Possession possession = thisTile.getPossession();
            p.add(possession);
            positions.add(tileNum);
            if (possession == Possession.None) { break; }
        }
        for (ScoringSequence seq: seqList.getList()) {
            if (seq.compareSequences(p) && !scoredTiles.contains(positions)) {
                ArrayList<Integer> reversedPositions = new ArrayList(positions);
                Collections.reverse(reversedPositions);
                getPlayer(lastPossession).addPoints(seq.getScore());
                scoredTiles.add(positions);
                scoredTiles.add(reversedPositions);
            }
        }
    }

    private Player getPlayer(Possession p) {
        if (p == Possession.Player1) {
            return player1;
        } else if (p == Possession.Player2) {
            return player2;
        }
        return null;
    }
}
