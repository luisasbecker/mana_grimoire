package org.commonmark.node;

/* JADX INFO: loaded from: classes7.dex */
public class LinkReferenceDefinition extends Node {
    private String destination;
    private String label;
    private String title;

    public LinkReferenceDefinition() {
    }

    public LinkReferenceDefinition(String str, String str2, String str3) {
        this.label = str;
        this.destination = str2;
        this.title = str3;
    }

    @Override // org.commonmark.node.Node
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getDestination() {
        return this.destination;
    }

    public String getLabel() {
        return this.label;
    }

    public String getTitle() {
        return this.title;
    }

    public void setDestination(String str) {
        this.destination = str;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
