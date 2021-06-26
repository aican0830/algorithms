package com.ad.string;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class StringTestMain {

    public static void main(String[] args) {


        String s = "leetcode";


        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);

            System.out.printf(c+":" + map.getOrDefault(c, 0)+1 + "\n");
        }

        for (int i = 0; i < s.length(); i++) {
            boolean b = (map.get(s.charAt(i)) == 1);

            System.out.printf(i + "" + b);
            if (map.get(s.charAt(i)) == 1) {
                break;
            }
        }


        StringSolution str = new StringSolution();

//        int ans = str.firstUniqChar(s);
//        System.out.printf(""+ans);


//        for (String key : map.keySet()) {
//            Integer value = map.get(key);
//            System.out.println("方法四：Key = " + key + ", Value = " + value);
//
//        }
    }

    static void test1() {
        char[] s = new char[]{'h','e','l','l','o'};
        char[] s1 = new char[]{'H','a','n','n','a','h'};

        StringSolution str = new StringSolution();

        str.reverseString(s);
        str.reverseString(s1);

        new TreeMap<>();
        new HashMap<>();

        for(int i = 0; i < s.length; i++) {
            System.err.printf(s[i]+",");
        }

        System.err.printf("\n=====================\n");

        for(int i = 0; i < s1.length; i++) {
            System.err.printf(s1[i]+",");
        }
    }
}
