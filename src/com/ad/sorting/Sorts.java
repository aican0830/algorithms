package com.ad.sorting;

public class Sorts {

    public void bubbleSort(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            for (int j = 1; j < nums.length - i; j++) {

                if (nums[j-1] > nums[j]) {
                    int tmp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = tmp;
                }
            }

        }
    }
}