package com.doanquochiep;

public class Main {

    public static void main(String[] args) {
        SearchTree tree = new SearchTree(null);
        tree.traverse(tree.getRoot());
        // Create a string data array to avoid typing loads of addItem instructions:
        String stringData = "5 7 3 9 8 2 1 0 4 6";
//        String stringData = "Darwin Brisbane Perth Melbourne Canberra Adelaide Sydney Canberra";
        String[] data = stringData.split(" ");
        for (String s : data) {
            // create new item with value set to the string s
            tree.addNode(new Node(s));
        }
        tree.traverse(tree.getRoot());
        tree.removeNode(new Node("3"));
        tree.traverse(tree.getRoot());

        tree.removeNode(new Node("5"));
        tree.traverse(tree.getRoot());

        tree.removeNode(new Node("0"));
        tree.removeNode(new Node("4"));
        tree.removeNode(new Node("2"));
        tree.traverse(tree.getRoot());

        tree.removeNode(new Node("9"));
        tree.traverse(tree.getRoot());
        tree.removeNode(new Node("8"));
        tree.traverse(tree.getRoot());
        tree.removeNode(new Node("6"));
        tree.traverse(tree.getRoot());
        tree.removeNode(tree.getRoot());
        tree.traverse(tree.getRoot());
        tree.removeNode(tree.getRoot());
        tree.traverse(tree.getRoot());



    }
}
