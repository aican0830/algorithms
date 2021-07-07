package com.ad.queue;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class QueueSolution {

    public boolean isValid(String s) {

        int n = s.length(); //获取字符串的长度
        if (n%2 == 1) { //长度不为偶数返回false
            return false;
        }

        //映射括号
        Map<Character, Character> paris = new HashMap<>();
        paris.put('}','{');
        paris.put(']','[');
        paris.put(')','(');

        //声明栈
        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (paris.containsKey(ch)) {

                //判断栈为空，或者出栈数据，不等于当前取到的左括号，返回false
                if (stack.isEmpty() || stack.peek() != paris.get(ch)) {
                    return false;
                }
                stack.pop(); //
            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }
}
