package com.doanquochiep;

public class Main {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.traverse(list.getRoot());
        // Create a string data array to avoid typing loads of addItem instructions:
        String stringData = "5 7 3 9 8 2 1 0 4 6";

        String[] data = stringData.split(" ");
        for (String s : data) {
            // create new item with value set to the string s
            list.addNode(new Node(s));
        }
        list.traverse(list.getRoot());
        list.removeNode(new Node("3"));
        list.traverse(list.getRoot());

        list.removeNode(new Node("5"));
        list.traverse(list.getRoot());

        list.removeNode(new Node("0"));
        list.removeNode(new Node("4"));
        list.removeNode(new Node("2"));
        list.traverse(list.getRoot());

        list.removeNode(new Node("9"));
        list.traverse(list.getRoot());
        list.removeNode(new Node("8"));
        list.traverse(list.getRoot());
        list.removeNode(new Node("6"));
        list.traverse(list.getRoot());
        list.removeNode(list.getRoot());
        list.traverse(list.getRoot());
        list.removeNode(list.getRoot());
        list.traverse(list.getRoot());


    }
}
