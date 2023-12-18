package com.ad.test;

import com.ad.tree.BinarySearchTree;
import com.mj.printer.BinaryTrees;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {



        int[] nums = new int[]{1,2,3,4,5,6,7,8,9};

        for (int i = 0; i < nums.length-1; i++) {
            System.out.print(nums[i]+" # ");
            for (int j = i+1; j < nums.length; j++) {
                System.out.print(nums[j]+" -> ");
            }
            System.out.println(" ");
        }
    }
}
