package com.ad.sorting;

public class Sorts {

    public void bubbleSort(int[] nums) {

        for (int i = nums.length - 1; i > 0; i--) {
            int last  = 1;
            for (int j = 1; j <= i; j++) {

                if (nums[j-1] > nums[j]) {
                    int tmp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = tmp;
                    last = j;
                }
            }
            i = last;

            System.out.printf("" + last+"_");

        }
    }
}
