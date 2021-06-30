package com.ad.sorting;

import com.ad.utils.PrintUtils;

public class TestMain {
    public static void main(String[] args) {

        int[] nums = new int[] {12,8,62,4,15,9,5,3,7,2,11,10};

        Sorts sorts = new Sorts();
        sorts.bubbleSort(nums);

        String res = PrintUtils.printArray(nums);
        System.out.printf("" + res);
    }
}
