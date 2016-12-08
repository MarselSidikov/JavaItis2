package ru.itis;

import ru.itis.tree.BinarySearchTree;
import ru.itis.tree.RedBlackTree;
import ru.itis.tree.Tree;

public class Main {

    public static void main(String[] args) {

        RedBlackTree tree = new RedBlackTree();

        int data[] =  {1, 2, 15, 17, 20, 21, 22};

        for (int currentElement :data) {
            tree.insert(currentElement);
        }

        tree.show();
    }
}
