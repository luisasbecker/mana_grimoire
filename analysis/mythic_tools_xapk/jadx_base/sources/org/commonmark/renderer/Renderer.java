package org.commonmark.renderer;

import org.commonmark.node.Node;

/* JADX INFO: loaded from: classes7.dex */
public interface Renderer {
    String render(Node node);

    void render(Node node, Appendable appendable);
}
