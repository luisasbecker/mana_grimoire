package org.commonmark.parser.block;

import org.commonmark.parser.SourceLines;

/* JADX INFO: loaded from: classes7.dex */
public interface MatchedBlockParser {
    BlockParser getMatchedBlockParser();

    SourceLines getParagraphLines();
}
