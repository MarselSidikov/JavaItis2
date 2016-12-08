package ru.itis.tree;

import com.sun.org.apache.regexp.internal.RE;

public class RedBlackTree {

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
        Node grandparent = getGrandparent(currentRoot);
        if (currentRoot.parent == null) {
            currentRoot.color = Color.BLACK;
        } else if (currentRoot.parent.color == Color.BLACK) {
            return currentRoot;
        } else if (uncle != null && uncle.color == Color.RED && currentRoot.parent.color == Color.RED){
            currentRoot.parent.color = Color.BLACK;
            uncle.color = Color.BLACK;
            grandparent.color = Color.RED;
            insertRecursive(grandparent, value);
        } else if (currentRoot == currentRoot.parent.right && currentRoot.parent == grandparent.left){
            rotateLeft(currentRoot.parent);
            currentRoot = currentRoot.left;
        } else if (currentRoot == currentRoot.parent.left && currentRoot.parent == grandparent.right) {
            rotateRight(currentRoot.parent);
            currentRoot = currentRoot.right;
        } else {
            currentRoot.parent.color = Color.BLACK;
            grandparent.color = Color.RED;
            if (currentRoot == currentRoot.parent.left && currentRoot.parent == grandparent.left) {
                rotateRight(grandparent);
            } else {
                rotateLeft(grandparent);
            }
        }

        return currentRoot;
    }

    public void show() {
        showTreeRecursive(root, 0);
    }

    private void showTreeRecursive(Node currentRoot, int level) {
        if (currentRoot != null) {
            showTreeRecursive(currentRoot.right, level + 1);

            for (int i = 0; i < level; i++)
            {
                System.out.print("--");
            }

            System.out.println(currentRoot.value + " " + currentRoot.color);

            showTreeRecursive(currentRoot.left, level + 1);
        }
    }
    private void rotateLeft(Node node) {
        Node pivot = node.right;
        pivot.parent = node.parent;
        if (node.parent != null) {
            if (node.parent.left == node) {
                node.parent.left = pivot;
            } else {
                node.parent.right = pivot;
            }
        }

        node.right = pivot.left;
        if (node.left != null) {
            pivot.left.parent = node;
        }

        node.parent = pivot;
        pivot.left = node;
    }

    private void rotateRight(Node node) {
        Node pivot = node.left;
        pivot.parent = node.parent;
        if (node.parent != null) {
            if (node.parent.left == node) {
                node.parent.left = pivot;
            } else {
                node.parent.right = pivot;
            }
        }

        node.left = pivot.right;
        if (node.right != null) {
            pivot.right.parent = node;
        }

        node.parent = pivot;
        pivot.right = node;
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
}
