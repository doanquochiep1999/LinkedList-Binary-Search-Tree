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
        //parent has right child
        if (parentNode.next() == currentNode) {
            //current node has no children
            if (currentNode.next() == null && currentNode.previous() == null) {
                parentNode.setNext(null);
                //current node only has right child
            } else if (currentNode.next() != null && currentNode.previous() == null) {
                parentNode.setNext(currentNode.next());
                //current node only has left child
            } else if (currentNode.previous() != null && currentNode.next() == null) {
                parentNode.setNext(currentNode.previous());
                //current node has two children
            } else {
                Node currentLeftmostNode = currentNode.next();
                Node leftmostParentNode = currentNode;
                //find the smallest node in the subright tree
                //moving to left if possible
                while (currentLeftmostNode.previous() != null) {
                    leftmostParentNode = currentLeftmostNode;
                    currentLeftmostNode = currentLeftmostNode.previous();
                }
                //replace the value in currentNode (node to be deleted) with that in currentLeftmostNode
                currentNode.setValue(currentLeftmostNode.getValue());
                //remove currentLeftmostNode
                if (leftmostParentNode.next() == currentLeftmostNode) {
                    leftmostParentNode.setNext(currentLeftmostNode.next());
                } else {
                    leftmostParentNode.setPrevious(currentLeftmostNode.next());
                }
            }
            //parent has left child
        } else if (parentNode.previous() == currentNode) {
            //current node has no children
            if (currentNode.next() == null && currentNode.previous() == null) {
                parentNode.setPrevious(null);
                //current node only has right child
            } else if (currentNode.next() != null && currentNode.previous() == null) {
                parentNode.setPrevious(currentNode.next());
                //current node only has left child
            } else if (currentNode.previous() != null && currentNode.next() == null) {
                parentNode.setPrevious(currentNode.previous());
                //current node has two children
            } else {
                Node currentLeftmostNode = currentNode.next();
                Node leftmostParentNode = currentNode;
                //find the smallest node in the subright tree
                //moving to left if possible
                while (currentLeftmostNode.previous() != null) {
                    leftmostParentNode = currentLeftmostNode;
                    currentLeftmostNode = currentLeftmostNode.previous();
                }
                //replace the value in currentNode (node to be deleted) with that in currentLeftmostNode
                currentNode.setValue(currentLeftmostNode.getValue());
                //remove currentLeftmostNode
                if (leftmostParentNode.next() == currentLeftmostNode) {
                    leftmostParentNode.setNext(currentLeftmostNode.next());
                } else {
                    leftmostParentNode.setPrevious(currentLeftmostNode.next());
                }
            }
            //we are removing the root node
        } else {
            if (currentNode.next() == null) {
                this.root = currentNode.previous();
            } else {
                Node currentLeftmostNode = currentNode.next();

                Node leftmostParentNode = currentNode;
                //find the smallest node in the subright tree
                //moving to left if possible
                while (currentLeftmostNode!=null && currentLeftmostNode.previous() != null) {
                    leftmostParentNode = currentLeftmostNode;
                    currentLeftmostNode = currentLeftmostNode.previous();
                }
                //replace the value in currentNode (node to be deleted) with that in currentLeftmostNode
                currentNode.setValue(currentLeftmostNode.getValue());
                //remove currentLeftmostNode
                if (leftmostParentNode.next() == currentLeftmostNode) {
                    leftmostParentNode.setNext(currentLeftmostNode.next());
                } else {
                    leftmostParentNode.setPrevious(currentLeftmostNode.next());
                }
            }
        }

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
