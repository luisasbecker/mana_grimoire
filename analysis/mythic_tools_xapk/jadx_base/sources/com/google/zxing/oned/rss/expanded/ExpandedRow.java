package com.google.zxing.oned.rss.expanded;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
final class ExpandedRow {
    private final List<ExpandedPair> pairs;
    private final int rowNumber;

    ExpandedRow(List<ExpandedPair> list, int i) {
        this.pairs = new ArrayList(list);
        this.rowNumber = i;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ExpandedRow) {
            return this.pairs.equals(((ExpandedRow) obj).pairs);
        }
        return false;
    }

    List<ExpandedPair> getPairs() {
        return this.pairs;
    }

    int getRowNumber() {
        return this.rowNumber;
    }

    public int hashCode() {
        return this.pairs.hashCode();
    }

    boolean isEquivalent(List<ExpandedPair> list) {
        return this.pairs.equals(list);
    }

    public String toString() {
        return "{ " + this.pairs + " }";
    }
}
