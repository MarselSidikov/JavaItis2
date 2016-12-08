package ru.itis.tree;

public class BinarySearchTree<K extends Comparable, V> implements Tree<K, V> {
    private class Node {
        K key;
        V value;
        Node left;
        Node right;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(K key, V value) {
        root = insertRecursive(root, key, value);
    }

    /**
     * Возвращает дерево со вставленным элементом
     * @param currentRoot корень дерева
     * @param value значение элемента
     * @return корень дерева
     */
    private Node insertRecursive(Node currentRoot, K key, V value) {
        if (currentRoot == null) {
            currentRoot = new Node(key, value);
        } else if (key.compareTo(currentRoot.key) < 0) {
            currentRoot.left = insertRecursive(currentRoot.left, key, value);
        } else {
            currentRoot.right = insertRecursive(currentRoot.right, key, value);
        }

        return currentRoot;
    }

    public void show() {
        showTreeRecursive(root, 0);
    }

    // выводит дерево с корнем currentRoot с уровнем level
    private void showTreeRecursive(Node currentRoot, int level) {
        if (currentRoot != null) {
            showTreeRecursive(currentRoot.right, level + 1);

            for (int i = 0; i < level; i++)
            {
                System.out.print("--");
            }

            System.out.println(currentRoot.key + "=" + currentRoot.value);

            showTreeRecursive(currentRoot.left, level + 1);
        }
    }

    public void showInfixOrder() {
        showInfixOrderRecursive(root);
        System.out.println();
    }

    private void showInfixOrderRecursive(Node currentRoot) {
        if (currentRoot != null) {
            showInfixOrderRecursive(currentRoot.left);
            System.out.print("{" +currentRoot.key + " " + currentRoot.value + "},");
            showInfixOrderRecursive(currentRoot.right);
        }
    }

    @Override
    public V find(K key) {
        return findRecursive(root, key);
    }

    private V findRecursive(Node currentRoot, K key) {
        if (key.compareTo(currentRoot.key) < 0) {
            return findRecursive(currentRoot.left, key);
        } else if (key.compareTo(currentRoot.key) > 0) {
            return findRecursive(currentRoot.right, key);
        } else {
            return currentRoot.value;
        }
    }

    @Override
    public void showPrefixOrder() {

    }

    @Override
    public void showPostfixOrder() {

    }
}
