package org.commonmark.node;

/* JADX INFO: loaded from: classes7.dex */
public class FencedCodeBlock extends Block {
    private char fenceChar;
    private int fenceIndent;
    private int fenceLength;
    private String info;
    private String literal;

    @Override // org.commonmark.node.Node
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public char getFenceChar() {
        return this.fenceChar;
    }

    public int getFenceIndent() {
        return this.fenceIndent;
    }

    public int getFenceLength() {
        return this.fenceLength;
    }

    public String getInfo() {
        return this.info;
    }

    public String getLiteral() {
        return this.literal;
    }

    public void setFenceChar(char c) {
        this.fenceChar = c;
    }

    public void setFenceIndent(int i) {
        this.fenceIndent = i;
    }

    public void setFenceLength(int i) {
        this.fenceLength = i;
    }

    public void setInfo(String str) {
        this.info = str;
    }

    public void setLiteral(String str) {
        this.literal = str;
    }
}
