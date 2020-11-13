package com.doanquochiep;

public interface NodeList {
    Node getRoot();
    boolean addNode(Node newNode);
    boolean removeNode(Node node);
    void traverse(Node root);
}
