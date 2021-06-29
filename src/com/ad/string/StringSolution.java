package com.ad.string;

import java.util.HashMap;
import java.util.Map;

public class StringSolution {

    /**
     * 125. 验证回文串
     * https://leetcode-cn.com/problems/valid-palindrome/
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        int len = s.length();
        StringBuffer sgood = new StringBuffer(); //保存字符串

        for (int i = 0; i < len; i++) {

            char ch = s.charAt(i); //取得字符
            if (Character.isLetterOrDigit(ch)) { //过滤特殊字符
                sgood.append(Character.toLowerCase(ch));
            }
        }

        //字符串反转
        StringBuffer sgoodRev = (new StringBuffer(sgood)).reverse();

        //反转后如果相等则是回文字符串
        return sgood.toString().equals(sgoodRev.toString());
    }

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


    public int firstUniqChar(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }
}
