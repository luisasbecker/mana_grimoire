package org.commonmark.internal;

import java.util.List;
import org.commonmark.node.LinkReferenceDefinition;
import org.commonmark.parser.InlineParserContext;
import org.commonmark.parser.delimiter.DelimiterProcessor;

/* JADX INFO: loaded from: classes7.dex */
public class InlineParserContextImpl implements InlineParserContext {
    private final List<DelimiterProcessor> delimiterProcessors;
    private final LinkReferenceDefinitions linkReferenceDefinitions;

    public InlineParserContextImpl(List<DelimiterProcessor> list, LinkReferenceDefinitions linkReferenceDefinitions) {
        this.delimiterProcessors = list;
        this.linkReferenceDefinitions = linkReferenceDefinitions;
    }

    @Override // org.commonmark.parser.InlineParserContext
    public List<DelimiterProcessor> getCustomDelimiterProcessors() {
        return this.delimiterProcessors;
    }

    @Override // org.commonmark.parser.InlineParserContext
    public LinkReferenceDefinition getLinkReferenceDefinition(String str) {
        return this.linkReferenceDefinitions.get(str);
    }
}
