package org.commonmark.parser;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.commonmark.Extension;
import org.commonmark.internal.DocumentParser;
import org.commonmark.internal.InlineParserContextImpl;
import org.commonmark.internal.InlineParserImpl;
import org.commonmark.internal.LinkReferenceDefinitions;
import org.commonmark.node.Block;
import org.commonmark.node.Node;
import org.commonmark.parser.block.BlockParserFactory;
import org.commonmark.parser.delimiter.DelimiterProcessor;

/* JADX INFO: loaded from: classes7.dex */
public class Parser {
    private final List<BlockParserFactory> blockParserFactories;
    private final List<DelimiterProcessor> delimiterProcessors;
    private final IncludeSourceSpans includeSourceSpans;
    private final InlineParserFactory inlineParserFactory;
    private final List<PostProcessor> postProcessors;

    public static class Builder {
        private InlineParserFactory inlineParserFactory;
        private final List<BlockParserFactory> blockParserFactories = new ArrayList();
        private final List<DelimiterProcessor> delimiterProcessors = new ArrayList();
        private final List<PostProcessor> postProcessors = new ArrayList();
        private Set<Class<? extends Block>> enabledBlockTypes = DocumentParser.getDefaultBlockParserTypes();
        private IncludeSourceSpans includeSourceSpans = IncludeSourceSpans.NONE;

        /* JADX INFO: Access modifiers changed from: private */
        public InlineParserFactory getInlineParserFactory() {
            InlineParserFactory inlineParserFactory = this.inlineParserFactory;
            return inlineParserFactory != null ? inlineParserFactory : new InlineParserFactory() { // from class: org.commonmark.parser.Parser.Builder.1
                @Override // org.commonmark.parser.InlineParserFactory
                public InlineParser create(InlineParserContext inlineParserContext) {
                    return new InlineParserImpl(inlineParserContext);
                }
            };
        }

        public Parser build() {
            return new Parser(this);
        }

        public Builder customBlockParserFactory(BlockParserFactory blockParserFactory) {
            if (blockParserFactory == null) {
                throw new NullPointerException("blockParserFactory must not be null");
            }
            this.blockParserFactories.add(blockParserFactory);
            return this;
        }

        public Builder customDelimiterProcessor(DelimiterProcessor delimiterProcessor) {
            if (delimiterProcessor == null) {
                throw new NullPointerException("delimiterProcessor must not be null");
            }
            this.delimiterProcessors.add(delimiterProcessor);
            return this;
        }

        public Builder enabledBlockTypes(Set<Class<? extends Block>> set) {
            if (set == null) {
                throw new NullPointerException("enabledBlockTypes must not be null");
            }
            DocumentParser.checkEnabledBlockTypes(set);
            this.enabledBlockTypes = set;
            return this;
        }

        public Builder extensions(Iterable<? extends Extension> iterable) {
            if (iterable == null) {
                throw new NullPointerException("extensions must not be null");
            }
            for (Extension extension : iterable) {
                if (extension instanceof ParserExtension) {
                    ((ParserExtension) extension).extend(this);
                }
            }
            return this;
        }

        public Builder includeSourceSpans(IncludeSourceSpans includeSourceSpans) {
            this.includeSourceSpans = includeSourceSpans;
            return this;
        }

        public Builder inlineParserFactory(InlineParserFactory inlineParserFactory) {
            this.inlineParserFactory = inlineParserFactory;
            return this;
        }

        public Builder postProcessor(PostProcessor postProcessor) {
            if (postProcessor == null) {
                throw new NullPointerException("postProcessor must not be null");
            }
            this.postProcessors.add(postProcessor);
            return this;
        }
    }

    public interface ParserExtension extends Extension {
        void extend(Builder builder);
    }

    private Parser(Builder builder) {
        this.blockParserFactories = DocumentParser.calculateBlockParserFactories(builder.blockParserFactories, builder.enabledBlockTypes);
        InlineParserFactory inlineParserFactory = builder.getInlineParserFactory();
        this.inlineParserFactory = inlineParserFactory;
        this.postProcessors = builder.postProcessors;
        List<DelimiterProcessor> list = builder.delimiterProcessors;
        this.delimiterProcessors = list;
        this.includeSourceSpans = builder.includeSourceSpans;
        inlineParserFactory.create(new InlineParserContextImpl(list, new LinkReferenceDefinitions()));
    }

    public static Builder builder() {
        return new Builder();
    }

    private DocumentParser createDocumentParser() {
        return new DocumentParser(this.blockParserFactories, this.inlineParserFactory, this.delimiterProcessors, this.includeSourceSpans);
    }

    private Node postProcess(Node node) {
        Iterator<PostProcessor> it = this.postProcessors.iterator();
        while (it.hasNext()) {
            node = it.next().process(node);
        }
        return node;
    }

    public Node parse(String str) {
        if (str != null) {
            return postProcess(createDocumentParser().parse(str));
        }
        throw new NullPointerException("input must not be null");
    }

    public Node parseReader(Reader reader) throws IOException {
        if (reader != null) {
            return postProcess(createDocumentParser().parse(reader));
        }
        throw new NullPointerException("input must not be null");
    }
}
