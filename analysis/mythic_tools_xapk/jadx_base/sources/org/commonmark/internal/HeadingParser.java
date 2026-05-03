package org.commonmark.internal;

import org.apache.commons.codec.language.Soundex;
import org.commonmark.internal.inline.Position;
import org.commonmark.internal.inline.Scanner;
import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Block;
import org.commonmark.node.Heading;
import org.commonmark.parser.InlineParser;
import org.commonmark.parser.SourceLine;
import org.commonmark.parser.SourceLines;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

/* JADX INFO: loaded from: classes7.dex */
public class HeadingParser extends AbstractBlockParser {
    private final Heading block;
    private final SourceLines content;

    public static class Factory extends AbstractBlockParserFactory {
        @Override // org.commonmark.parser.block.BlockParserFactory
        public BlockStart tryStart(ParserState parserState, MatchedBlockParser matchedBlockParser) {
            HeadingParser atxHeading;
            if (parserState.getIndent() >= Parsing.CODE_BLOCK_INDENT) {
                return BlockStart.none();
            }
            SourceLine line = parserState.getLine();
            int nextNonSpaceIndex = parserState.getNextNonSpaceIndex();
            if (line.getContent().charAt(nextNonSpaceIndex) == '#' && (atxHeading = HeadingParser.getAtxHeading(line.substring(nextNonSpaceIndex, line.getContent().length()))) != null) {
                return BlockStart.of(atxHeading).atIndex(line.getContent().length());
            }
            int setextHeadingLevel = HeadingParser.getSetextHeadingLevel(line.getContent(), nextNonSpaceIndex);
            if (setextHeadingLevel > 0) {
                SourceLines paragraphLines = matchedBlockParser.getParagraphLines();
                if (!paragraphLines.isEmpty()) {
                    return BlockStart.of(new HeadingParser(setextHeadingLevel, paragraphLines)).atIndex(line.getContent().length()).replaceActiveBlockParser();
                }
            }
            return BlockStart.none();
        }
    }

    public HeadingParser(int i, SourceLines sourceLines) {
        Heading heading = new Heading();
        this.block = heading;
        heading.setLevel(i);
        this.content = sourceLines;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static HeadingParser getAtxHeading(SourceLine sourceLine) {
        Scanner scannerOf = Scanner.of(SourceLines.of(sourceLine));
        int iMatchMultiple = scannerOf.matchMultiple('#');
        if (iMatchMultiple == 0 || iMatchMultiple > 6) {
            return null;
        }
        if (!scannerOf.hasNext()) {
            return new HeadingParser(iMatchMultiple, SourceLines.empty());
        }
        char cPeek = scannerOf.peek();
        if (cPeek != ' ' && cPeek != '\t') {
            return null;
        }
        scannerOf.whitespace();
        Position position = scannerOf.position();
        Position position2 = position;
        loop0: while (true) {
            boolean z = true;
            while (scannerOf.hasNext()) {
                char cPeek2 = scannerOf.peek();
                if (cPeek2 == '\t' || cPeek2 == ' ') {
                    scannerOf.next();
                } else {
                    if (cPeek2 != '#') {
                        scannerOf.next();
                        position2 = scannerOf.position();
                    } else if (z) {
                        scannerOf.matchMultiple('#');
                        int iWhitespace = scannerOf.whitespace();
                        if (scannerOf.hasNext()) {
                            position2 = scannerOf.position();
                        }
                        if (iWhitespace > 0) {
                            break;
                        }
                    } else {
                        scannerOf.next();
                        position2 = scannerOf.position();
                    }
                    z = false;
                }
            }
            break loop0;
        }
        SourceLines source = scannerOf.getSource(position, position2);
        return source.getContent().isEmpty() ? new HeadingParser(iMatchMultiple, SourceLines.empty()) : new HeadingParser(iMatchMultiple, source);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getSetextHeadingLevel(CharSequence charSequence, int i) {
        char cCharAt = charSequence.charAt(i);
        if (cCharAt != '-') {
            if (cCharAt != '=') {
                return 0;
            }
            if (isSetextHeadingRest(charSequence, i + 1, '=')) {
                return 1;
            }
        }
        return isSetextHeadingRest(charSequence, i + 1, Soundex.SILENT_MARKER) ? 2 : 0;
    }

    private static boolean isSetextHeadingRest(CharSequence charSequence, int i, char c) {
        return Parsing.skipSpaceTab(charSequence, Parsing.skip(c, charSequence, i, charSequence.length()), charSequence.length()) >= charSequence.length();
    }

    @Override // org.commonmark.parser.block.BlockParser
    public Block getBlock() {
        return this.block;
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public void parseInlines(InlineParser inlineParser) {
        inlineParser.parse(this.content, this.block);
    }

    @Override // org.commonmark.parser.block.BlockParser
    public BlockContinue tryContinue(ParserState parserState) {
        return BlockContinue.none();
    }
}
