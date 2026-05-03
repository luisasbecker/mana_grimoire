package org.commonmark.parser;

import org.commonmark.node.SourceSpan;

/* JADX INFO: loaded from: classes7.dex */
public class SourceLine {
    private final CharSequence content;
    private final SourceSpan sourceSpan;

    private SourceLine(CharSequence charSequence, SourceSpan sourceSpan) {
        if (charSequence == null) {
            throw new NullPointerException("content must not be null");
        }
        this.content = charSequence;
        this.sourceSpan = sourceSpan;
    }

    public static SourceLine of(CharSequence charSequence, SourceSpan sourceSpan) {
        return new SourceLine(charSequence, sourceSpan);
    }

    public CharSequence getContent() {
        return this.content;
    }

    public SourceSpan getSourceSpan() {
        return this.sourceSpan;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SourceLine substring(int i, int i2) {
        SourceSpan sourceSpanOf;
        CharSequence charSequenceSubSequence = this.content.subSequence(i, i2);
        SourceSpan sourceSpan = this.sourceSpan;
        if (sourceSpan != null) {
            int i3 = i2 - i;
            sourceSpanOf = i3 != 0 ? SourceSpan.of(this.sourceSpan.getLineIndex(), sourceSpan.getColumnIndex() + i, i3) : null;
        }
        return of(charSequenceSubSequence, sourceSpanOf);
    }
}
