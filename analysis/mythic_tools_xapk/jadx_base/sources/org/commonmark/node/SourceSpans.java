package org.commonmark.node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class SourceSpans {
    private List<SourceSpan> sourceSpans;

    public static SourceSpans empty() {
        return new SourceSpans();
    }

    public void addAll(List<SourceSpan> list) {
        if (list.isEmpty()) {
            return;
        }
        if (this.sourceSpans == null) {
            this.sourceSpans = new ArrayList();
        }
        boolean zIsEmpty = this.sourceSpans.isEmpty();
        List<SourceSpan> list2 = this.sourceSpans;
        if (zIsEmpty) {
            list2.addAll(list);
            return;
        }
        int size = list2.size() - 1;
        SourceSpan sourceSpan = this.sourceSpans.get(size);
        SourceSpan sourceSpan2 = list.get(0);
        if (sourceSpan.getLineIndex() != sourceSpan2.getLineIndex() || sourceSpan.getColumnIndex() + sourceSpan.getLength() != sourceSpan2.getColumnIndex()) {
            this.sourceSpans.addAll(list);
        } else {
            this.sourceSpans.set(size, SourceSpan.of(sourceSpan.getLineIndex(), sourceSpan.getColumnIndex(), sourceSpan.getLength() + sourceSpan2.getLength()));
            this.sourceSpans.addAll(list.subList(1, list.size()));
        }
    }

    public void addAllFrom(Iterable<? extends Node> iterable) {
        Iterator<? extends Node> it = iterable.iterator();
        while (it.hasNext()) {
            addAll(it.next().getSourceSpans());
        }
    }

    public List<SourceSpan> getSourceSpans() {
        List<SourceSpan> list = this.sourceSpans;
        return list != null ? list : Collections.emptyList();
    }
}
