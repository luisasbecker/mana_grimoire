package org.commonmark.parser.delimiter;

import org.commonmark.node.Text;

/* JADX INFO: loaded from: classes7.dex */
public interface DelimiterRun {
    boolean canClose();

    boolean canOpen();

    Text getCloser();

    Iterable<Text> getClosers(int i);

    Text getOpener();

    Iterable<Text> getOpeners(int i);

    int length();

    int originalLength();
}
