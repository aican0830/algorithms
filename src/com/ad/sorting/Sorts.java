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

    public void shellSort(int[] nums) {

        int len = nums.length;
        int step = len;

        while(step >= 1) {

            step = step/2;
            System.out.printf("" + step);
            for (int i = step; i < len; i++) {
                for (int j = i; j - step >= 0; j-=step) {

                    if (nums[j-step] > nums[j]) {
                        int tmp = nums[j-step];
                        nums[j-step] = nums[j];
                        nums[j] = tmp;
                    } else {
                        break;
                    }
                }
            }
        }
    }
}
