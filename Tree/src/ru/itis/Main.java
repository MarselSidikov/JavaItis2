package ru.itis;

import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
	    Tree<Integer, String> tree = new BinarySearchTree<>();

        int data[] = {8, 4, 11, 0, 5, 17, 11, 16};
        int i = 0;
        for (int currentElement : data) {
            tree.insert(currentElement, "Hello" + i);
            i++;
        }

        tree.show();
        tree.showInfixOrder();

        String value = tree.find(5);
        System.out.println(value);

        TreeMap<String, Integer> map = new TreeMap<>();

        /**
        int sortedData[] = {1, 2, 15, 17, 20, 21, 22};

        Tree onSortedTree = new BinarySearchTree();

        for (int currentElement : sortedData) {
            onSortedTree.insert(currentElement);
        }

        onSortedTree.show();
        **/
    }
}
