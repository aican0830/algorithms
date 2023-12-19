package com.ad.leetcode;

import java.util.*;

public class LC17 {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return new ArrayList<>();
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        LinkedList<String> res = new LinkedList<>();
        search("", digits, 0, res, map);
        return res;
    }

    private void search(String s, String digits, int i, LinkedList<String> res, HashMap<Character, String> map) {

        //terminator
        if (i == digits.length()) {
            res.add(s);
            return;
        }
        //process
        String letters = map.get(digits.charAt(i));
        for (int j = 0; j < letters.length(); j++) {
            //drill down
            search(s+letters.charAt(j), digits, i+1, res, map);
        }
    }

    public static void main(String[] args) {

        System.out.println((new LC17()).letterCombinations("23"));
    }
}
