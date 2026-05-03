package org.commonmark.internal;

import java.util.LinkedList;
import java.util.ListIterator;
import org.commonmark.parser.delimiter.DelimiterProcessor;
import org.commonmark.parser.delimiter.DelimiterRun;

/* JADX INFO: loaded from: classes7.dex */
class StaggeredDelimiterProcessor implements DelimiterProcessor {
    private final char delim;
    private int minLength = 0;
    private LinkedList<DelimiterProcessor> processors = new LinkedList<>();

    StaggeredDelimiterProcessor(char c) {
        this.delim = c;
    }

    private DelimiterProcessor findProcessor(int i) {
        for (DelimiterProcessor delimiterProcessor : this.processors) {
            if (delimiterProcessor.getMinLength() <= i) {
                return delimiterProcessor;
            }
        }
        return this.processors.getFirst();
    }

    void add(DelimiterProcessor delimiterProcessor) {
        int minLength = delimiterProcessor.getMinLength();
        ListIterator<DelimiterProcessor> listIterator = this.processors.listIterator();
        while (listIterator.hasNext()) {
            DelimiterProcessor next = listIterator.next();
            int minLength2 = next.getMinLength();
            if (minLength > minLength2) {
                listIterator.previous();
                listIterator.add(delimiterProcessor);
                return;
            } else if (minLength == minLength2) {
                throw new IllegalArgumentException("Cannot add two delimiter processors for char '" + this.delim + "' and minimum length " + minLength + "; conflicting processors: " + next + ", " + delimiterProcessor);
            }
        }
        this.processors.add(delimiterProcessor);
        this.minLength = minLength;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public char getClosingCharacter() {
        return this.delim;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public int getMinLength() {
        return this.minLength;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public char getOpeningCharacter() {
        return this.delim;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public int process(DelimiterRun delimiterRun, DelimiterRun delimiterRun2) {
        return findProcessor(delimiterRun.length()).process(delimiterRun, delimiterRun2);
    }
}
