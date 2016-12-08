package ru.itis.tree;

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

        Node(int value, Color color) {
            this(value);
            this.color = color;
        }
    }

    private Node root;

    public void insert(int element) {
        root = insertRecursive(root, element);
    }

    private Node insertRecursive(Node currentRoot, int value) {
        if (currentRoot == null) {
            return new Node(value, Color.BLACK);
        }
        if (value <= currentRoot.value) {
            if (currentRoot.left == null) {
                Node node = new Node(value);
                node.parent = currentRoot;
                currentRoot.left = node;
            } else {
                currentRoot.left = insertRecursive(currentRoot.left, value);
            }
            fixTree(currentRoot.left);
        } else {
            if (currentRoot.right == null) {
                Node node = new Node(value);
                node.parent = currentRoot;
                currentRoot.right = node;
            } else {
                currentRoot.right = insertRecursive(currentRoot.right, value);
            }
            fixTree(currentRoot.right);
        }
        return currentRoot;
    }

    private void fixTree(Node currentRoot) {
        Node uncle = getUncle(currentRoot);
        Node grandparent = getGrandparent(currentRoot);
        if (currentRoot.parent == null) {
            currentRoot.color = Color.BLACK;
        } else if (currentRoot.parent.color == Color.BLACK) {
            return;
        } else if (uncle != null && uncle.color == Color.RED && currentRoot.parent.color == Color.RED){
            currentRoot.parent.color = Color.BLACK;
            uncle.color = Color.BLACK;
            grandparent.color = Color.RED;
            fixTree(grandparent);
        } else if (currentRoot == currentRoot.parent.right && currentRoot.parent == grandparent.left){
            rotateLeft(currentRoot.parent);
        } else if (currentRoot == currentRoot.parent.left && currentRoot.parent == grandparent.right) {
            rotateRight(currentRoot.parent);
        } else {
            currentRoot.parent.color = Color.BLACK;
            grandparent.color = Color.RED;
            if (currentRoot == currentRoot.parent.left && currentRoot.parent == grandparent.left) {
                rotateRight(grandparent);
            } else {
                rotateLeft(grandparent);
            }
        }
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
        if (pivot.left != null) {
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
        if (pivot.right != null) {
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
