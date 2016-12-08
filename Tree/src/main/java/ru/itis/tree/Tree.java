package ru.itis.tree;

public interface Tree<K extends Comparable, V> {
    void insert(K key, V value);
    void show();
    void showInfixOrder();
    V find(K key);
    /**
     * Вершина, левое поддерево, правое поддерево
     */
    void showPrefixOrder();

    /**
     * Левое поддерево, правое поддерево, вершина
     */
    void showPostfixOrder();
}
