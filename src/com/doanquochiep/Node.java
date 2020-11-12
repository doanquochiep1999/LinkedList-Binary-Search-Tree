package com.doanquochiep;

public class Node {
    private Object value;
    private Node rightLink = null;
    private Node leftLink = null;

    public Node(Object value) {
        this.value = value;
    }

    public Node next() {
        return this.rightLink;
    }

    public Node setNext(Node node) {
        this.rightLink = node;
        return this.rightLink;
    }

    public Node previous() {
        return this.leftLink;
    }

    public Node setPrevious(Node node) {
        this.leftLink = node;
        return this.leftLink;
    }

    public Object getValue() {
        return this.value;
    }

    public int compareTo(Node node) {
        if (node != null) {
            return ((String) this.value).compareTo((String) node.getValue());
        }
        //node == null
        return -1;
    }


}
