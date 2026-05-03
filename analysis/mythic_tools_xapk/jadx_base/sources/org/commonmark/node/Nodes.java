package org.commonmark.node;

import java.util.Iterator;

/* JADX INFO: loaded from: classes7.dex */
public class Nodes {

    private static class NodeIterable implements Iterable<Node> {
        private final Node end;
        private final Node first;

        private NodeIterable(Node node, Node node2) {
            this.first = node;
            this.end = node2;
        }

        @Override // java.lang.Iterable
        public Iterator<Node> iterator() {
            return new NodeIterator(this.first, this.end);
        }
    }

    private static class NodeIterator implements Iterator<Node> {
        private final Node end;
        private Node node;

        private NodeIterator(Node node, Node node2) {
            this.node = node;
            this.end = node2;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Node node = this.node;
            return (node == null || node == this.end) ? false : true;
        }

        @Override // java.util.Iterator
        public Node next() {
            Node node = this.node;
            this.node = node.getNext();
            return node;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }
    }

    private Nodes() {
    }

    public static Iterable<Node> between(Node node, Node node2) {
        return new NodeIterable(node.getNext(), node2);
    }
}
