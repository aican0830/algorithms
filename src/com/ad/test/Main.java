package com.ad.test;

import com.ad.tree.BinarySearchTree;
import com.mj.printer.BinaryTrees;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {


        BinarySearchTree binarySearchTree = new BinarySearchTree<>();

        binarySearchTree.add(4);
        binarySearchTree.add(2);
        binarySearchTree.add(7);

        binarySearchTree.add(1);

        binarySearchTree.add(3);
        binarySearchTree.add(6);
        binarySearchTree.add(9);
        //System.out.printf("" + binarySearchTree.size());


        BinaryTrees.println(binarySearchTree);
        //System.out.printf(""+BinaryTrees.printString(binarySearchTree));
    }
}
