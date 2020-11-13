package com.doanquochiep;

public class SearchTree implements NodeList {
    private Node root = null;

    public SearchTree(Node root) {
        this.root = root;
    }

    @Override
    public Node getRoot() {
        return this.root;
    }

    @Override
    public boolean addNode(Node newNode) {
        if (this.root == null) {
            //empty tree, add node to the root
            this.root = newNode;
            return true;
        }
        //otherwise, start comparing from the root of the tree
        Node currentNode = this.root;
        while (this.root != null) {
            int comparison = currentNode.compareTo(newNode);
            if (comparison > 0) {
                //move to the left tree if possible
                if (currentNode.previous() != null) {
                    currentNode = currentNode.previous();
                } else {
                    //add node here since there's no node to the left
                    currentNode.setPrevious(newNode);
                    return true;
                }
            } else if (comparison < 0) {
                //move to the right tree if possible
                if (currentNode.next() != null) {
                    currentNode = currentNode.next();
                } else {
                    //add node here since there's no node to the right
                    currentNode.setNext(newNode);
                    return true;
                }
            } else {
                //equal, so don't add
                System.out.println(newNode.getValue() + " is already present");
                return false;
            }
        }
        // we can't actually get here, but Java complains if there's no return
        return false;
    }

    @Override
    public boolean removeNode(Node node) {
        if (node != null) {
            System.out.println("Deleting node " + node.getValue());
        }
        Node currentNode = this.root;
        Node parentNode = currentNode;
        while (currentNode != null) {
            int comparison = currentNode.compareTo(node);
            if (comparison < 0) {
                //move to the left tree if possible
                parentNode = currentNode;
                currentNode = currentNode.next();
            } else if (comparison > 0) {
                //move to the right tree if possible
                parentNode = currentNode;
                currentNode = currentNode.previous();
            } else {
                //equal, found node to be deleted
                performRemoval(currentNode, parentNode);
                return true;
            }
        }
        return false;
    }

    private void performRemoval(Node currentNode, Node parentNode) {
        //case 1: deletion node has no subtrees
        if (currentNode.previous() == null && currentNode.next() == null) {
            //Special case: deletion node is the root node
            //If the root has no subtrees, removing that will result in an EMPTY tree
            if (currentNode == this.root) {
                this.root = null;
                return;
            }
            //if currentNode is right child of parentNode
            if (parentNode.next() == currentNode) {
                parentNode.setNext(null);
            } else {
                parentNode.setPrevious(null);
            }
            return;
        }

        //case 2: deletion node has one subtree
        //if deletion node has right subtree only
        if (currentNode.previous() == null) {
            //special case: if currentNode is the root
            if (currentNode == this.root) {
                this.root = currentNode.next();
                return;
            }
            //if parentNode has right currentNode
            if (parentNode.next() == currentNode) {
                parentNode.setNext(currentNode.next());
                return;
            }
            parentNode.setPrevious(currentNode.next());
            return;
        }
        //if deletion node has left subtree only
        if (currentNode.next() == null) {
            //special case: if currentNode is the root
            if (currentNode == this.root) {
                this.root = currentNode.previous();
                return;
            }
            //if parentNode has right currentNode
            if (parentNode.next() == currentNode) {
                parentNode.setNext(currentNode.previous());
                return;
            }
            parentNode.setPrevious(currentNode.previous());
            return;
        }
        //case 3: if deletion node has two subtrees
        //find the minimum node in the subright tree
        Node currentLeftmostNode = currentNode.next();
        Node leftmostParentNode = currentNode;
        //right subtree has no left subtree
        if (currentLeftmostNode.previous() == null) {
            //leftmostParentNode will be mimimum node
            //replace the currentNode's value with leftmostParentNode's value
            currentNode.setValue(currentLeftmostNode.getValue());
            //remove currentLeftmostNode
            currentNode.setNext(currentLeftmostNode.next());
            return;
        }
        while(currentLeftmostNode.previous() != null) {
            leftmostParentNode = currentLeftmostNode;
            currentLeftmostNode = currentLeftmostNode.previous();
        }
        //leftmostParentNode will be mimimum node
        //replace the currentNode's value with leftmostParentNode's value
        currentNode.setValue(currentLeftmostNode.getValue());
        //remove currentLeftmostNode
        leftmostParentNode.setPrevious(currentLeftmostNode.next());
    }


    @Override
    public void traverse(Node root) {
        if (root != null) {
            traverse(root.previous());
            System.out.println(root.getValue());
            traverse(root.next());
        }
    }


}
