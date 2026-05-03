package org.commonmark.internal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.commonmark.internal.BlockQuoteParser;
import org.commonmark.internal.FencedCodeBlockParser;
import org.commonmark.internal.HeadingParser;
import org.commonmark.internal.HtmlBlockParser;
import org.commonmark.internal.IndentedCodeBlockParser;
import org.commonmark.internal.ListBlockParser;
import org.commonmark.internal.ThematicBreakParser;
import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Block;
import org.commonmark.node.BlockQuote;
import org.commonmark.node.Document;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.Heading;
import org.commonmark.node.HtmlBlock;
import org.commonmark.node.IndentedCodeBlock;
import org.commonmark.node.LinkReferenceDefinition;
import org.commonmark.node.ListBlock;
import org.commonmark.node.Paragraph;
import org.commonmark.node.SourceSpan;
import org.commonmark.node.ThematicBreak;
import org.commonmark.parser.IncludeSourceSpans;
import org.commonmark.parser.InlineParser;
import org.commonmark.parser.InlineParserFactory;
import org.commonmark.parser.SourceLine;
import org.commonmark.parser.SourceLines;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockParser;
import org.commonmark.parser.block.BlockParserFactory;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;
import org.commonmark.parser.delimiter.DelimiterProcessor;

/* JADX INFO: loaded from: classes7.dex */
public class DocumentParser implements ParserState {
    private static final Set<Class<? extends Block>> CORE_FACTORY_TYPES = new LinkedHashSet(Arrays.asList(BlockQuote.class, Heading.class, FencedCodeBlock.class, HtmlBlock.class, ThematicBreak.class, ListBlock.class, IndentedCodeBlock.class));
    private static final Map<Class<? extends Block>, BlockParserFactory> NODES_TO_CORE_FACTORIES;
    private boolean blank;
    private final List<BlockParserFactory> blockParserFactories;
    private boolean columnIsInTab;
    private final List<DelimiterProcessor> delimiterProcessors;
    private final DocumentBlockParser documentBlockParser;
    private final IncludeSourceSpans includeSourceSpans;
    private final InlineParserFactory inlineParserFactory;
    private SourceLine line;
    private int lineIndex = -1;
    private int index = 0;
    private int column = 0;
    private int nextNonSpace = 0;
    private int nextNonSpaceColumn = 0;
    private int indent = 0;
    private final LinkReferenceDefinitions definitions = new LinkReferenceDefinitions();
    private final List<OpenBlockParser> openBlockParsers = new ArrayList();
    private final List<BlockParser> allBlockParsers = new ArrayList();

    private static class MatchedBlockParserImpl implements MatchedBlockParser {
        private final BlockParser matchedBlockParser;

        public MatchedBlockParserImpl(BlockParser blockParser) {
            this.matchedBlockParser = blockParser;
        }

        @Override // org.commonmark.parser.block.MatchedBlockParser
        public BlockParser getMatchedBlockParser() {
            return this.matchedBlockParser;
        }

        @Override // org.commonmark.parser.block.MatchedBlockParser
        public SourceLines getParagraphLines() {
            BlockParser blockParser = this.matchedBlockParser;
            return blockParser instanceof ParagraphParser ? ((ParagraphParser) blockParser).getParagraphLines() : SourceLines.empty();
        }
    }

    private static class OpenBlockParser {
        private final BlockParser blockParser;
        private int sourceIndex;

        OpenBlockParser(BlockParser blockParser, int i) {
            this.blockParser = blockParser;
            this.sourceIndex = i;
        }
    }

    static {
        HashMap map = new HashMap();
        map.put(BlockQuote.class, new BlockQuoteParser.Factory());
        map.put(Heading.class, new HeadingParser.Factory());
        map.put(FencedCodeBlock.class, new FencedCodeBlockParser.Factory());
        map.put(HtmlBlock.class, new HtmlBlockParser.Factory());
        map.put(ThematicBreak.class, new ThematicBreakParser.Factory());
        map.put(ListBlock.class, new ListBlockParser.Factory());
        map.put(IndentedCodeBlock.class, new IndentedCodeBlockParser.Factory());
        NODES_TO_CORE_FACTORIES = Collections.unmodifiableMap(map);
    }

    public DocumentParser(List<BlockParserFactory> list, InlineParserFactory inlineParserFactory, List<DelimiterProcessor> list2, IncludeSourceSpans includeSourceSpans) {
        this.blockParserFactories = list;
        this.inlineParserFactory = inlineParserFactory;
        this.delimiterProcessors = list2;
        this.includeSourceSpans = includeSourceSpans;
        DocumentBlockParser documentBlockParser = new DocumentBlockParser();
        this.documentBlockParser = documentBlockParser;
        activateBlockParser(new OpenBlockParser(documentBlockParser, 0));
    }

    private void activateBlockParser(OpenBlockParser openBlockParser) {
        this.openBlockParsers.add(openBlockParser);
    }

    private void addChild(OpenBlockParser openBlockParser) {
        while (!getActiveBlockParser().canContain(openBlockParser.blockParser.getBlock())) {
            closeBlockParsers(1);
        }
        getActiveBlockParser().getBlock().appendChild(openBlockParser.blockParser.getBlock());
        activateBlockParser(openBlockParser);
    }

    private void addDefinitionsFrom(ParagraphParser paragraphParser) {
        for (LinkReferenceDefinition linkReferenceDefinition : paragraphParser.getDefinitions()) {
            paragraphParser.getBlock().insertBefore(linkReferenceDefinition);
            this.definitions.add(linkReferenceDefinition);
        }
    }

    private void addLine() {
        CharSequence content;
        boolean z = this.columnIsInTab;
        int i = this.index;
        if (z) {
            CharSequence charSequenceSubSequence = this.line.getContent().subSequence(i + 1, this.line.getContent().length());
            int iColumnsToNextTabStop = Parsing.columnsToNextTabStop(this.column);
            StringBuilder sb = new StringBuilder(charSequenceSubSequence.length() + iColumnsToNextTabStop);
            for (int i2 = 0; i2 < iColumnsToNextTabStop; i2++) {
                sb.append(' ');
            }
            sb.append(charSequenceSubSequence);
            content = sb.toString();
        } else {
            SourceLine sourceLine = this.line;
            content = i == 0 ? sourceLine.getContent() : sourceLine.getContent().subSequence(this.index, this.line.getContent().length());
        }
        getActiveBlockParser().addLine(SourceLine.of(content, this.includeSourceSpans == IncludeSourceSpans.BLOCKS_AND_INLINES ? SourceSpan.of(this.lineIndex, this.index, content.length()) : null));
        addSourceSpans();
    }

    private void addSourceSpans() {
        if (this.includeSourceSpans != IncludeSourceSpans.NONE) {
            for (int i = 1; i < this.openBlockParsers.size(); i++) {
                OpenBlockParser openBlockParser = this.openBlockParsers.get(i);
                int i2 = openBlockParser.sourceIndex;
                int length = this.line.getContent().length() - i2;
                if (length != 0) {
                    openBlockParser.blockParser.addSourceSpan(SourceSpan.of(this.lineIndex, i2, length));
                }
            }
        }
    }

    private void advance() {
        char cCharAt = this.line.getContent().charAt(this.index);
        this.index++;
        int i = this.column;
        if (cCharAt == '\t') {
            this.column = i + Parsing.columnsToNextTabStop(i);
        } else {
            this.column = i + 1;
        }
    }

    public static List<BlockParserFactory> calculateBlockParserFactories(List<BlockParserFactory> list, Set<Class<? extends Block>> set) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        Iterator<Class<? extends Block>> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(NODES_TO_CORE_FACTORIES.get(it.next()));
        }
        return arrayList;
    }

    public static void checkEnabledBlockTypes(Set<Class<? extends Block>> set) {
        for (Class<? extends Block> cls : set) {
            Map<Class<? extends Block>, BlockParserFactory> map = NODES_TO_CORE_FACTORIES;
            if (!map.containsKey(cls)) {
                throw new IllegalArgumentException("Can't enable block type " + cls + ", possible options are: " + map.keySet());
            }
        }
    }

    private void closeBlockParsers(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            BlockParser blockParser = deactivateBlockParser().blockParser;
            finalize(blockParser);
            this.allBlockParsers.add(blockParser);
        }
    }

    private OpenBlockParser deactivateBlockParser() {
        return this.openBlockParsers.remove(r1.size() - 1);
    }

    private void finalize(BlockParser blockParser) {
        if (blockParser instanceof ParagraphParser) {
            addDefinitionsFrom((ParagraphParser) blockParser);
        }
        blockParser.closeBlock();
    }

    private Document finalizeAndProcess() {
        closeBlockParsers(this.openBlockParsers.size());
        processInlines();
        return this.documentBlockParser.getBlock();
    }

    private BlockStartImpl findBlockStart(BlockParser blockParser) {
        MatchedBlockParserImpl matchedBlockParserImpl = new MatchedBlockParserImpl(blockParser);
        Iterator<BlockParserFactory> it = this.blockParserFactories.iterator();
        while (it.hasNext()) {
            BlockStart blockStartTryStart = it.next().tryStart(this, matchedBlockParserImpl);
            if (blockStartTryStart instanceof BlockStartImpl) {
                return (BlockStartImpl) blockStartTryStart;
            }
        }
        return null;
    }

    private void findNextNonSpace() {
        int i = this.index;
        int i2 = this.column;
        this.blank = true;
        int length = this.line.getContent().length();
        while (true) {
            if (i >= length) {
                break;
            }
            char cCharAt = this.line.getContent().charAt(i);
            if (cCharAt == '\t') {
                i++;
                i2 += 4 - (i2 % 4);
            } else if (cCharAt != ' ') {
                this.blank = false;
                break;
            } else {
                i++;
                i2++;
            }
        }
        this.nextNonSpace = i;
        this.nextNonSpaceColumn = i2;
        this.indent = i2 - this.column;
    }

    public static Set<Class<? extends Block>> getDefaultBlockParserTypes() {
        return CORE_FACTORY_TYPES;
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x0115, code lost:
    
        setNewIndex(r11.nextNonSpace);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void parseLine(CharSequence charSequence) {
        setLine(charSequence);
        int i = 1;
        for (int i2 = 1; i2 < this.openBlockParsers.size(); i2++) {
            OpenBlockParser openBlockParser = this.openBlockParsers.get(i2);
            BlockParser blockParser = openBlockParser.blockParser;
            findNextNonSpace();
            BlockContinue blockContinueTryContinue = blockParser.tryContinue(this);
            if (!(blockContinueTryContinue instanceof BlockContinueImpl)) {
                break;
            }
            BlockContinueImpl blockContinueImpl = (BlockContinueImpl) blockContinueTryContinue;
            openBlockParser.sourceIndex = getIndex();
            if (blockContinueImpl.isFinalize()) {
                addSourceSpans();
                closeBlockParsers(this.openBlockParsers.size() - i2);
                return;
            }
            if (blockContinueImpl.getNewIndex() != -1) {
                setNewIndex(blockContinueImpl.getNewIndex());
            } else if (blockContinueImpl.getNewColumn() != -1) {
                setNewColumn(blockContinueImpl.getNewColumn());
            }
            i++;
        }
        int size = this.openBlockParsers.size() - i;
        blockParser = this.openBlockParsers.get(i - 1).blockParser;
        int i3 = this.index;
        boolean zIsContainer = (blockParser.getBlock() instanceof Paragraph) || blockParser.isContainer();
        boolean z = false;
        while (true) {
            if (!zIsContainer) {
                break;
            }
            i3 = this.index;
            findNextNonSpace();
            if (isBlank() || (this.indent < Parsing.CODE_BLOCK_INDENT && Parsing.isLetter(this.line.getContent(), this.nextNonSpace))) {
                break;
            }
            BlockStartImpl blockStartImplFindBlockStart = findBlockStart(blockParser);
            if (blockStartImplFindBlockStart == null) {
                setNewIndex(this.nextNonSpace);
                break;
            }
            int index = getIndex();
            if (size > 0) {
                closeBlockParsers(size);
                size = 0;
            }
            if (blockStartImplFindBlockStart.getNewIndex() != -1) {
                setNewIndex(blockStartImplFindBlockStart.getNewIndex());
            } else if (blockStartImplFindBlockStart.getNewColumn() != -1) {
                setNewColumn(blockStartImplFindBlockStart.getNewColumn());
            }
            List<SourceSpan> sourceSpans = blockStartImplFindBlockStart.isReplaceActiveBlockParser() ? prepareActiveBlockParserForReplacement().getSourceSpans() : null;
            for (BlockParser blockParser2 : blockStartImplFindBlockStart.getBlockParsers()) {
                addChild(new OpenBlockParser(blockParser2, index));
                if (sourceSpans != null) {
                    blockParser2.getBlock().setSourceSpans(sourceSpans);
                }
                zIsContainer = blockParser2.isContainer();
            }
            z = true;
        }
        if (!z && !isBlank() && getActiveBlockParser().canHaveLazyContinuationLines()) {
            List<OpenBlockParser> list = this.openBlockParsers;
            list.get(list.size() - 1).sourceIndex = i3;
            addLine();
            return;
        }
        if (size > 0) {
            closeBlockParsers(size);
        }
        if (!blockParser2.isContainer()) {
            addLine();
        } else if (isBlank()) {
            addSourceSpans();
        } else {
            addChild(new OpenBlockParser(new ParagraphParser(), i3));
            addLine();
        }
    }

    private Block prepareActiveBlockParserForReplacement() {
        BlockParser blockParser = deactivateBlockParser().blockParser;
        if (blockParser instanceof ParagraphParser) {
            addDefinitionsFrom((ParagraphParser) blockParser);
        }
        blockParser.closeBlock();
        blockParser.getBlock().unlink();
        return blockParser.getBlock();
    }

    private void processInlines() {
        InlineParser inlineParserCreate = this.inlineParserFactory.create(new InlineParserContextImpl(this.delimiterProcessors, this.definitions));
        Iterator<BlockParser> it = this.allBlockParsers.iterator();
        while (it.hasNext()) {
            it.next().parseInlines(inlineParserCreate);
        }
    }

    private void setLine(CharSequence charSequence) {
        this.lineIndex++;
        this.index = 0;
        this.column = 0;
        this.columnIsInTab = false;
        CharSequence charSequencePrepareLine = Parsing.prepareLine(charSequence);
        this.line = SourceLine.of(charSequencePrepareLine, this.includeSourceSpans != IncludeSourceSpans.NONE ? SourceSpan.of(this.lineIndex, 0, charSequencePrepareLine.length()) : null);
    }

    private void setNewColumn(int i) {
        int i2;
        int i3 = this.nextNonSpaceColumn;
        if (i >= i3) {
            this.index = this.nextNonSpace;
            this.column = i3;
        }
        int length = this.line.getContent().length();
        while (true) {
            i2 = this.column;
            if (i2 >= i || this.index == length) {
                break;
            } else {
                advance();
            }
        }
        if (i2 <= i) {
            this.columnIsInTab = false;
            return;
        }
        this.index--;
        this.column = i;
        this.columnIsInTab = true;
    }

    private void setNewIndex(int i) {
        int i2 = this.nextNonSpace;
        if (i >= i2) {
            this.index = i2;
            this.column = this.nextNonSpaceColumn;
        }
        int length = this.line.getContent().length();
        while (true) {
            int i3 = this.index;
            if (i3 >= i || i3 == length) {
                break;
            } else {
                advance();
            }
        }
        this.columnIsInTab = false;
    }

    @Override // org.commonmark.parser.block.ParserState
    public BlockParser getActiveBlockParser() {
        return this.openBlockParsers.get(r1.size() - 1).blockParser;
    }

    @Override // org.commonmark.parser.block.ParserState
    public int getColumn() {
        return this.column;
    }

    @Override // org.commonmark.parser.block.ParserState
    public int getIndent() {
        return this.indent;
    }

    @Override // org.commonmark.parser.block.ParserState
    public int getIndex() {
        return this.index;
    }

    @Override // org.commonmark.parser.block.ParserState
    public SourceLine getLine() {
        return this.line;
    }

    @Override // org.commonmark.parser.block.ParserState
    public int getNextNonSpaceIndex() {
        return this.nextNonSpace;
    }

    @Override // org.commonmark.parser.block.ParserState
    public boolean isBlank() {
        return this.blank;
    }

    public Document parse(Reader reader) throws IOException {
        BufferedReader bufferedReader = reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader);
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return finalizeAndProcess();
            }
            parseLine(line);
        }
    }

    public Document parse(String str) {
        int i = 0;
        while (true) {
            int iFindLineBreak = Parsing.findLineBreak(str, i);
            if (iFindLineBreak == -1) {
                break;
            }
            parseLine(str.substring(i, iFindLineBreak));
            i = iFindLineBreak + 1;
            if (i < str.length() && str.charAt(iFindLineBreak) == '\r' && str.charAt(i) == '\n') {
                i = iFindLineBreak + 2;
            }
        }
        if (str.length() > 0 && (i == 0 || i < str.length())) {
            parseLine(str.substring(i));
        }
        return finalizeAndProcess();
    }
}
