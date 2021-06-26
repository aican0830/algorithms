package com.ad.arraylist;

import java.util.ArrayList;
import java.util.List;

public class ArrayListSolution {

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
