package org.commonmark.node;

/* JADX INFO: loaded from: classes7.dex */
public class OrderedList extends ListBlock {
    private char delimiter;
    private int startNumber;

    @Override // org.commonmark.node.Node
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public char getDelimiter() {
        return this.delimiter;
    }

    public int getStartNumber() {
        return this.startNumber;
    }

    public void setDelimiter(char c) {
        this.delimiter = c;
    }

    public void setStartNumber(int i) {
        this.startNumber = i;
    }
}
