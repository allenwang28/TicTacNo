package com.old.ttnhelpers;

import com.old.gameobjects.Possession;

import java.util.ArrayList;

/**
 * Created by allenwang on 7/29/15.
 */
public class ScoringSequenceList {
    private ArrayList<ScoringSequence> seqList;

    public ScoringSequenceList(ScoringSequence...sequences) {
        this.seqList = new ArrayList();
        for(ScoringSequence sequence: sequences) {
            this.seqList.add(sequence);
        }
    }

    public ArrayList<ScoringSequence> getList() {
        return seqList;
    }
}
