package com.ad.utils;

public class PrintUtils {

    public static String printArray(int[] nums) {

        StringBuffer s = new StringBuffer();

        s.append("[");

        for (int i = 0; i < nums.length; i++) {

            if (i > 0) {
                s.append(", ");
            }

            s.append(nums[i]);
        }

        s.append("]");

        return s.toString();
    }
}
