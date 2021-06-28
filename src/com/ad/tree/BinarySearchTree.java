package com.ad.tree;

import com.mj.printer.BinaryTreeInfo;

public class BinarySearchTree<E> implements BinaryTreeInfo {

    private int size;
    private Node<E> root;

    public int size() {
        return size;
    }

    public void add(E element) {

        //根为空，创建节点赋值给根节点
        if (root == null) {
            root = new Node<>(element, null);
            size++;
            return;
        }

        //查找添加到节点的位置
        //添加元素和节点比较，小于节点，添加到左，大于节点添加到右
        Node<E> node = root;
        Node<E> parent = root;
        int cmp = 0;
        do  {
            cmp = compare(element, node.element);
            parent = node;
            if (cmp > 0) {
                node = node.right;
            } else if (cmp < 0) {
                node = node.left;
            } else {
                node.element = element;
                return;
            }
        } while(node != null);

        Node<E> newNode = new Node<>(element, parent);
        if (cmp > 0) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }

        size++;
    }

    public void remove() {}

    public void clear() {
        size = 0;
        root = null;
    }

    public int height() {
        return 0;
    }

    //比较t1 和t2的大小
    private int compare(E t1, E t2) {
        return ((Comparable<E>)t1).compareTo(t2);
    };

    static class Node<E> {
        E element;
        Node<E> parent;
        Node<E> left;
        Node<E> right;

        public Node() {

        }

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }
    }

    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node<E>)node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node<E>)node).right;
    }

    @Override
    public Object string(Object node) {
        Node<E> myNode = (Node<E>)node;
        String parentString = "null";
        if (myNode.parent != null) {
            parentString = myNode.parent.element.toString();
        }
        return myNode.element + "_p(" + parentString + ")";
    }

}
