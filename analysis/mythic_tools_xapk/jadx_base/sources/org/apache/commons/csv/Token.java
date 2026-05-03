package org.apache.commons.csv;

/* JADX INFO: loaded from: classes7.dex */
final class Token {
    private static final int DEFAULT_CAPACITY = 50;
    boolean isQuoted;
    boolean isReady;
    Type type = Type.INVALID;
    final StringBuilder content = new StringBuilder(50);

    enum Type {
        INVALID,
        TOKEN,
        EOF,
        EORECORD,
        COMMENT
    }

    Token() {
    }

    void reset() {
        this.content.setLength(0);
        this.type = Type.INVALID;
        this.isReady = false;
        this.isQuoted = false;
    }

    public String toString() {
        return this.type + " [" + this.content.toString() + "]";
    }
}
