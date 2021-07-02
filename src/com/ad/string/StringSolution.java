package com.ad.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
     * 212. 单词搜索 II
     * https://leetcode-cn.com/problems/word-search-ii/
     *
     * @param board
     * @param words
     * @return
     */
    class TrieNode {
        HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        String word = null;
        public TrieNode() {}
    }

    char[][] _board = null;
    ArrayList<String> _result = new ArrayList<String>();

    public List<String> findWords(char[][] board, String[] words) {
        // Step 1). Construct the Trie
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;

            for (Character letter : word.toCharArray()) {
                if (node.children.containsKey(letter)) {
                    node = node.children.get(letter);
                } else {
                    TrieNode newNode = new TrieNode();
                    node.children.put(letter, newNode);
                    node = newNode;
                }
            }
            node.word = word;  // store words in Trie
        }

        this._board = board;
        // Step 2). Backtracking starting for each cell in the board
        for (int row = 0; row < board.length; ++row) {
            for (int col = 0; col < board[row].length; ++col) {
                if (root.children.containsKey(board[row][col])) {
                    backtracking(row, col, root);
                }
            }
        }

        return this._result;
    }
    private void backtracking(int row, int col, TrieNode parent) {
        Character letter = this._board[row][col];
        TrieNode currNode = parent.children.get(letter);

        // check if there is any match
        if (currNode.word != null) {
            this._result.add(currNode.word);
            currNode.word = null;
        }

        // mark the current letter before the EXPLORATION
        this._board[row][col] = '#';

        // explore neighbor cells in around-clock directions: up, right, down, left
        int[] rowOffset = {-1, 0, 1, 0};
        int[] colOffset = {0, 1, 0, -1};
        for (int i = 0; i < 4; ++i) {
            int newRow = row + rowOffset[i];
            int newCol = col + colOffset[i];
            if (newRow < 0 || newRow >= this._board.length || newCol < 0
                    || newCol >= this._board[0].length) {
                continue;
            }
            if (currNode.children.containsKey(this._board[newRow][newCol])) {
                backtracking(newRow, newCol, currNode);
            }
        }

        // End of EXPLORATION, restore the original letter in the board.
        this._board[row][col] = letter;

        // Optimization: incrementally remove the leaf nodes
        if (currNode.children.isEmpty()) {
            parent.children.remove(letter);
        }
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
