package ru.itis;

import com.sun.org.apache.regexp.internal.RE;

public class RedBlackTree {
    /**

    private enum Color {
        RED, BLACK
    }

    private static class Node {
        int value;
        Node left;
        Node right;
        Node parent;
        Color color;

        Node(int value) {
            this.value = value;
            this.color = Color.RED;
        }
    }

    private Node root;

    public void insert(int element) {
        root = insertRecursive(root, element);
    }

    private Node insertRecursive(Node currentRoot, int value) {
        if (currentRoot == null) {
            currentRoot = new Node(value);
        } else if (value <= currentRoot.value) {
            currentRoot.left = insertRecursive(currentRoot.left, value);
            currentRoot.left.parent = currentRoot;
        } else {
            currentRoot.right = insertRecursive(currentRoot.right, value);
            currentRoot.right.parent = currentRoot;
        }

        Node uncle = getUncle(currentRoot);

        if (currentRoot.parent == null) {
            currentRoot.color = Color.BLACK;
            return currentRoot;
        } else if (currentRoot.parent.color == Color.BLACK) {
            return currentRoot;
        } else if (uncle != null && uncle.color == Color.RED && currentRoot.parent.color == Color.RED){
            currentRoot.parent.color = Color.BLACK;
            uncle.color = Color.BLACK;
            currentRoot.parent.parent.color = Color.RED;
            currentRoot.parent.parent = insertRecursive(currentRoot.parent.parent, value);
            return currentRoot;
        } else if (currentRoot){

        }
    }

    private void rotateLeft(Node node) {

    }
    private Node getGrandparent(Node node) {
        if (node != null && node.parent != null) {
            return node.parent.parent;
        } else {
            return null;
        }
    }

    private Node getUncle(Node node) {
        Node grandparent = getGrandparent(node);
        if (grandparent == null) {
            return null;
        } else if (node.parent == grandparent.left) {
            return grandparent.right;
        } else {
            return grandparent.left;
        }
    }
     **/
}
