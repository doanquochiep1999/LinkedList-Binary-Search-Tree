package com.doanquochiep;

public class MyLinkedList implements NodeList{
    private Node root = null;

    @Override
    public Node getRoot() {
        return this.root;
    }

    @Override
    public boolean addNode(Node newNode) {
        if (root == null) {
            root = newNode;
            return true;
        }
        Node currentNode = this.root;
        while (currentNode != null) {
            int comparison = currentNode.compareTo(newNode);
            if (comparison < 0) {
                //move to the right if possible
                if (currentNode.next() != null) {
                    currentNode = currentNode.next();
                } else {
                    //add node here
                    currentNode.setNext(newNode).setPrevious(currentNode);
                    return true;
                }
            } else if (comparison > 0) {
                //add node before
                if (currentNode.previous() != null) {
                    currentNode.previous().setNext(newNode).setPrevious(currentNode.previous());
                    newNode.setNext(currentNode).setPrevious(newNode);
                } else {
                    //current node is the root, then insert node before root
                    currentNode.setPrevious(newNode).setNext(currentNode);
                    this.root = newNode;
                }
                return true;
            } else {
                //equal
                System.out.println(newNode.getValue() + " is already in the list, not added.");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeNode(Node node) {
        Node currentNode = this.root;
        System.out.println("Deleting node " + node.getValue());
        while (currentNode != null) {
            if (currentNode.compareTo(node) == 0) {
                //found the node to be deleted
                if (currentNode == this.root) {
                    if (this.root.next() != null) {
                        this.root = this.root.next();
                        this.root.setPrevious(null);
                    } else {
                        this.root = null;
                    }
                } else {
                    if (currentNode.next() != null) {
                        currentNode.previous().setNext(currentNode.next()).setPrevious(currentNode.previous());
                    } else {
                        currentNode.previous().setNext(null);
                    }

                }
                return true;
            }
            currentNode = currentNode.next();
        }
        //reached the end of the list without find the node to delete
        return false;
    }

    @Override
    public void traverse(Node root) {
        if (root == null) {
            System.out.println("The list is empty");
        } else {
            Node currentNode = root;
            while (currentNode != null) {
                System.out.println(currentNode.getValue() + " ");
                currentNode = currentNode.next();
            }
        }

    }

}
