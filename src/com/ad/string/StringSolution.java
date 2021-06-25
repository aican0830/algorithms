package com.ad.string;

public class StringSolution {

    /**
     * 344. 反转字符串
     * https://leetcode-cn.com/problems/reverse-string/
     *
     * @param s
     */
    public void reverseString(char[] s) {

        int len = s.length;

        for(int i = 0; i < len/2; i++) {

            char tmp = s[i];
            s[i] = s[len-1-i];
            s[len-1-i] = tmp;
        }
    }
}
