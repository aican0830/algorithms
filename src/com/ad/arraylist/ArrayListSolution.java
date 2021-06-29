package com.ad.arraylist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayListSolution {

    /**
     * 88. 合并两个有序数组
     * https://leetcode-cn.com/problems/merge-sorted-array/
     *
     * 逆向双指针
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int p1 = m-1, p2 = n-1;
        int tail = m+n-1;
        int cur = 0;

        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                cur = nums2[p2--];
            } else if (p2 == -1) {
                cur = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }

            nums1[tail--] = cur;
        }
    }

    /**
     * 169. 多数元素
     * https://leetcode-cn.com/problems/majority-element/
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {

        int ans = 0;
        int len = nums.length >> 1; // n/2的长度
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            //存储到map key为数组的值，key存在value+1
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }

            //判断元素出现的次数
            if (map.get(nums[i]) > len) {
                return nums[i];
            }
        }

        return ans;
    }


    /**
     * 240. 搜索二维矩阵 II
     * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {

        //暴力解法，二维数组循环
        for (int i = 0; i < matrix.length; i++) {

            int[] second = matrix[i];
            for (int j = 0; j < second.length; j++) {

                if (target == matrix[i][j]) return true;
            }
        }

        return false;
    }

    /**
     * 448. 找到所有数组中消失的数字
     * https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
     *
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> ans = new ArrayList<>();

        // 1）先遍历一遍数组，原地修改数组，下标标记：
        // 假设 nums[i] = num，则将 num-1位置标为负数：[num-1] * -1
        for (int i = 0; i < nums.length; i++) {

            int pos = Math.abs(nums[i]) - 1;
            if (nums[pos] > 0) {
                nums[pos] = -nums[pos];
            }
        }

        // 2）再遍历一遍数组，检查每个位置躺着的数字是否是负数: [i] < 0 ?
        // 如果不是，则表明：缺 i+1 这个数字
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > 0) {
                ans.add(i+1);
            }
        }

        return ans;
    }
}
