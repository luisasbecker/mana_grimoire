package org.commonmark.parser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.commonmark.node.SourceSpan;

/* JADX INFO: loaded from: classes7.dex */
public class SourceLines {
    private final List<SourceLine> lines = new ArrayList();

    public static SourceLines empty() {
        return new SourceLines();
    }

    public static SourceLines of(List<SourceLine> list) {
        SourceLines sourceLines = new SourceLines();
        sourceLines.lines.addAll(list);
        return sourceLines;
    }

    public static SourceLines of(SourceLine sourceLine) {
        SourceLines sourceLines = new SourceLines();
        sourceLines.addLine(sourceLine);
        return sourceLines;
    }

    public void addLine(SourceLine sourceLine) {
        this.lines.add(sourceLine);
    }

    public String getContent() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.lines.size(); i++) {
            if (i != 0) {
                sb.append('\n');
            }
            sb.append(this.lines.get(i).getContent());
        }
        return sb.toString();
    }

    public List<SourceLine> getLines() {
        return this.lines;
    }

    public List<SourceSpan> getSourceSpans() {
        ArrayList arrayList = new ArrayList();
        Iterator<SourceLine> it = this.lines.iterator();
        while (it.hasNext()) {
            SourceSpan sourceSpan = it.next().getSourceSpan();
            if (sourceSpan != null) {
                arrayList.add(sourceSpan);
            }
        }
        return arrayList;
    }

    public boolean isEmpty() {
        return this.lines.isEmpty();
    }
}
