package com.old.ttnhelpers;

import com.old.gameobjects.Possession;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by allenwang on 7/29/15.
 */
public class ScoringSequence {
    public static final Possession scoringSequence1[] = { Possession.Player1, Possession.Player1, Possession.Player1 };
    public static final Possession scoringSequence2[] = { Possession.Player2, Possession.Player2, Possession.Player2 };
    public static final Possession scoringSequence3[] = { Possession.Player1, Possession.Player2, Possession.Player1, Possession.Player2 };
    public static final Possession scoringSequence4[] = { Possession.Player2, Possession.Player1, Possession.Player2, Possession.Player1 };

    private Possession sequence[];
    private int score;

    public ScoringSequence(Possession seq[], int score) {
        this.sequence = seq;
        this.score = score;
    }

    public boolean compareSequences(ArrayList<Possession> seq1) {
        if (seq1.size() != sequence.length) { return false; }
        Iterator it = seq1.iterator();
        int len = sequence.length;
        for (int i = 0; i < len; ++i) {
            if (it.next() != sequence[i]) {
                return false;
            }
        }
        return true;
    }

    public int getScore() {
        return this.score;
    }

    public Possession[] getSequence() {
        return this.sequence;
    }
}
