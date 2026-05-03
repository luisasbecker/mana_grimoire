package org.commonmark.parser.delimiter;

/* JADX INFO: loaded from: classes7.dex */
public interface DelimiterProcessor {
    char getClosingCharacter();

    int getMinLength();

    char getOpeningCharacter();

    int process(DelimiterRun delimiterRun, DelimiterRun delimiterRun2);
}
