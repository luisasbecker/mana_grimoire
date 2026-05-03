package org.commonmark.internal;

import java.util.LinkedHashMap;
import java.util.Map;
import org.commonmark.internal.util.Escaping;
import org.commonmark.node.LinkReferenceDefinition;

/* JADX INFO: loaded from: classes7.dex */
public class LinkReferenceDefinitions {
    private final Map<String, LinkReferenceDefinition> definitions = new LinkedHashMap();

    public void add(LinkReferenceDefinition linkReferenceDefinition) {
        String strNormalizeLabelContent = Escaping.normalizeLabelContent(linkReferenceDefinition.getLabel());
        if (this.definitions.containsKey(strNormalizeLabelContent)) {
            return;
        }
        this.definitions.put(strNormalizeLabelContent, linkReferenceDefinition);
    }

    public LinkReferenceDefinition get(String str) {
        return this.definitions.get(Escaping.normalizeLabelContent(str));
    }
}
