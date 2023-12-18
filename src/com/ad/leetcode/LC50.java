package com.ad.leetcode;

import java.util.Arrays;

public class LC50 {

    public double myPow(double x, int n) {
        //1. 暴力
        double ans = 1.0;
//        for (double i = 0; i < n; i++) {
//            ans *= x;
//        }


        long N = n;

        if (n < 0) {
            x = 1/x;
            N = -N;
        }

        ans = fastPow(x, N);
        return ans;
    }

    public double fastPow(double x, long n) {
        //2. 分治
        double ans = 1.0;
        if (n == 0) return ans;

        double half = fastPow(x, n/2);

        if (n % 2 == 0) {
            ans = half * half;
        } else {
            ans = half * half * x;
        }

        return ans;
    }
    public static void main(String[] args) {

        System.out.println((new LC50()).myPow(2.10000, 3));
    }
}
