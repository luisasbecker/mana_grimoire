package org.commonmark.ext.gfm.strikethrough.internal;

import java.util.Set;
import org.apache.commons.io.IOUtils;
import org.commonmark.node.Node;
import org.commonmark.renderer.text.TextContentNodeRendererContext;
import org.commonmark.renderer.text.TextContentWriter;

/* JADX INFO: loaded from: classes7.dex */
public class StrikethroughTextContentNodeRenderer extends StrikethroughNodeRenderer {
    private final TextContentNodeRendererContext context;
    private final TextContentWriter textContent;

    public StrikethroughTextContentNodeRenderer(TextContentNodeRendererContext textContentNodeRendererContext) {
        this.context = textContentNodeRendererContext;
        this.textContent = textContentNodeRendererContext.getWriter();
    }

    private void renderChildren(Node node) {
        Node firstChild = node.getFirstChild();
        while (firstChild != null) {
            Node next = firstChild.getNext();
            this.context.render(firstChild);
            firstChild = next;
        }
    }

    @Override // org.commonmark.ext.gfm.strikethrough.internal.StrikethroughNodeRenderer, org.commonmark.renderer.NodeRenderer
    public /* bridge */ /* synthetic */ Set getNodeTypes() {
        return super.getNodeTypes();
    }

    @Override // org.commonmark.renderer.NodeRenderer
    public void render(Node node) {
        this.textContent.write(IOUtils.DIR_SEPARATOR_UNIX);
        renderChildren(node);
        this.textContent.write(IOUtils.DIR_SEPARATOR_UNIX);
    }
}
