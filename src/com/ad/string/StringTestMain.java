package com.ad.string;

public class StringTestMain {

    public static void main(String[] args) {

        char[] s = new char[]{'h','e','l','l','o'};
        char[] s1 = new char[]{'H','a','n','n','a','h'};

        StringSolution str = new StringSolution();

        str.reverseString(s);
        str.reverseString(s1);

        for(int i = 0; i < s.length; i++) {
            System.err.printf(s[i]+",");
        }

        System.err.printf("\n=====================\n");

        for(int i = 0; i < s1.length; i++) {
            System.err.printf(s1[i]+",");
        }
    }
}
