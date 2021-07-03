package com.ad.sorting;

public class ShellSort {

    public void sort(int[] nums) {

        // 7 6 3 5 4 1 2
        // 7 6 3 5 step = 3


        int len = nums.length;
        int step = len;

        while(step >= 1) {

            step = step/2;
            for (int i = step; i < len; i++) {
                for (int j = i; j - step >= 0; j-=step) {

                    if (nums[j-step] > nums[j]) {
                        int tmp = nums[j];
                        nums[j] = nums[j-step] ;
                        nums[j-step] = tmp;
                    } else {
                        break;
                    }
                }
            }

        }


    }
}
