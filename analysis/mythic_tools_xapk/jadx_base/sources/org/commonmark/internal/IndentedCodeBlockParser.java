package org.commonmark.internal;

import java.util.ArrayList;
import java.util.List;
import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Block;
import org.commonmark.node.IndentedCodeBlock;
import org.commonmark.node.Paragraph;
import org.commonmark.parser.SourceLine;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

/* JADX INFO: loaded from: classes7.dex */
public class IndentedCodeBlockParser extends AbstractBlockParser {
    private final IndentedCodeBlock block = new IndentedCodeBlock();
    private final List<CharSequence> lines = new ArrayList();

    public static class Factory extends AbstractBlockParserFactory {
        @Override // org.commonmark.parser.block.BlockParserFactory
        public BlockStart tryStart(ParserState parserState, MatchedBlockParser matchedBlockParser) {
            return (parserState.getIndent() < Parsing.CODE_BLOCK_INDENT || parserState.isBlank() || (parserState.getActiveBlockParser().getBlock() instanceof Paragraph)) ? BlockStart.none() : BlockStart.of(new IndentedCodeBlockParser()).atColumn(parserState.getColumn() + Parsing.CODE_BLOCK_INDENT);
        }
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public void addLine(SourceLine sourceLine) {
        this.lines.add(sourceLine.getContent());
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public void closeBlock() {
        int size = this.lines.size() - 1;
        while (size >= 0 && Parsing.isBlank(this.lines.get(size))) {
            size--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size + 1; i++) {
            sb.append(this.lines.get(i));
            sb.append('\n');
        }
        this.block.setLiteral(sb.toString());
    }

    @Override // org.commonmark.parser.block.BlockParser
    public Block getBlock() {
        return this.block;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public BlockContinue tryContinue(ParserState parserState) {
        return parserState.getIndent() >= Parsing.CODE_BLOCK_INDENT ? BlockContinue.atColumn(parserState.getColumn() + Parsing.CODE_BLOCK_INDENT) : parserState.isBlank() ? BlockContinue.atIndex(parserState.getNextNonSpaceIndex()) : BlockContinue.none();
    }
}
