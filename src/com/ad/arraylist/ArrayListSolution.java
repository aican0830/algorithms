package src.com.ad.arraylist;

import com.ad.utils.PrintUtils;

import java.lang.reflect.Array;
import java.util.*;

public class ArrayListSolution {

    /**
     * 14. 最长公共前缀
     * https://leetcode-cn.com/problems/longest-common-prefix/
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return null;
        }

        //标记第一个字符串长度，循环完成，如果找到则为最长子串，否则未找到
        int length = strs[0].length();
        //N个字符串
        int count = strs.length;

        // strs[0] = l e e t        [0][0]
        // strs[1] = l e e t c      [1][0]
        // strs[2] = l e e t c o    [2][0]
        // strs[3] = l e e          [3][0]
        for (int i = 0; i < length; i++) {
            // 0,1,2,3,4...
            //定义每行第一个字符串，下面每个字符串和它对比，如果相等有不相等，查找结束
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                // 1,2,3,4
                // i = {0,1,2,3}
                // i == strs[j].length() 表示如果后面的字符串比第一行长度短则循环结束,且防止下标越界
                if (i == strs[j].length() || c != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }

    /**
     * 28. Implement strStr()
     * https://leetcode-cn.com/problems/implement-strstr/
     *
     * 1. 查找字符串出现的坐标，使用两层循环
     * 2. 外层循环，因为要查找字符串，所有外层循环的边界为，字符串长度-查找字符串的长度
     * 3. 内层循环为待查找字符串的长度，如果循环中有不相等，则标记为false，反之为true;
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {

        int ans = -1;
        int fast = needle.length();
        int slow = 0;
        int len = haystack.length();

        while (slow <= len-fast) {

            boolean flag = true;
            int i = 0;
            while (i < fast) {
                if (haystack.charAt(slow+i) != needle.charAt(i)) {
                    flag = false;
                    break;
                }
                i++;
            }
            if (flag) {
                return slow;
            }

            slow++;
        }
        return ans;
    }

    public int strStr2(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        for (int i = 0; i + m <= n; i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 56. 合并区间
     * https://leetcode-cn.com/problems/merge-intervals/
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {

        if (intervals.length == 0) {
            return new int[0][2];
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> merged = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int L = intervals[i][0], R = intervals[i][1];

            if (merged.size() == 0 || merged.get(merged.size()-1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size()-1)[1] = Math.max(merged.get(merged.size()-1)[1], R);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }


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
     * 151. 翻转字符串里的单词
     * https://leetcode-cn.com/problems/reverse-words-in-a-string/
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {

        //去除空格
        s = s.trim();

        //分割成字符串数组
        String[] strArrays = s.split("\\s+");
        int len = strArrays.length;

        //反转
        for (int i = 0; i < len / 2 ; i++) {
            String temp = strArrays[i];
            strArrays[i] = strArrays[len - i -1];
            strArrays[len - i - 1] = temp;
        }

        //空格连接后返回字符串
        return String.join(" ", strArrays);
    }

    /**
     * 使用系统函数解决
     * 1. 根据规律用空格把字符串分割成字符串数组
     * 2. 对数组进行反转，原生代码，参考反转数组、反转字符串
     * 3. 用空格把字符串数组拼接成字符串返回
     *
     * @param s
     * @return
     */
    public String reverseWords2(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
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

        for (int num : nums) {

            //存储到map key为数组的值，key存在value+1
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }

            //判断元素出现的次数
            if (map.get(num) > len) {
                return num;
            }
        }

        return ans;
    }


    /**
     * 121. 买卖股票的最佳时机
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        int maxProfit = 0; //保存最大利润
        int minPrice = Integer.MAX_VALUE; //设置购入最小值

        for (int price : prices) {

            if (price < minPrice) { //如果当天价格小于最小值，则覆盖最小值
                minPrice = price;
            } else if (price - minPrice > maxProfit) { // 某天股票价格-最低购入，则利润最大，
                maxProfit = price - minPrice; // 设置最大利润
            }
        }

        return maxProfit;
    }

    /**
     * 167. 两数之和 II - 输入有序数组
     * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
     * 暴力解法
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {

        int len = numbers.length;
        int[] ans = new int[2];

        for (int i = 0; i < len - 1; i++) {
            int val = target - numbers[i];

            for (int j = i+1; j < len; j++) {

                if (val == numbers[j]) {

                    ans[0] = i+1;
                    ans[1] = j+1;
                }
            }
        }

        return ans;
    }


    /**
     *
     * 167. 两数之和 II - 输入有序数组
     * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSumBinarySearch(int[] numbers, int target) {

        for (int i = 0; i < numbers.length; ++i) {
            //初始化，范围内[i, n];
            int low = i + 1, high = numbers.length - 1;
            while(low <= high) {

                //分两部分查找
                int mid = (high-low)/2 + low;
                if (numbers[mid] == target - numbers[i]) {
                    return new int[]{i+1, mid+1};
                } else if (numbers[mid] > target - numbers[i]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return new int[]{-1, -1};
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
     * 283. 移动零
     * https://leetcode-cn.com/problems/move-zeroes/
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {

        int n = nums.length;
        int slow = 0;
        int fast = 0;

        while (fast < n) {

            if(nums[fast] != 0) {
                if (fast > slow) {
                    nums[slow] = nums[fast];
                    nums[fast] = 0;
                    System.out.println(""+PrintUtils.printArray(nums));
                }
                slow++;


            }

            fast++;
        }
    }

    public void moveZeroes1(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                System.out.println("left:" + left+" right:"+right);
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }


    private void swap(int[] nums, int i1, int i2) {

        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
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

    /**
     * 498. 对角线遍历
     * https://leetcode-cn.com/problems/diagonal-traverse/
     *
     * @param mat
     * @return
     */
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) return new int[0];

        int N = mat.length;
        int M = mat[0].length;

        int[] result = new int[M*N];

        int k = 0 ;
        ArrayList<Integer> intermediate = new ArrayList<>();

        for (int i = 0; i < (N + M - 1); i++) {

            intermediate.clear();

            // M = 3, N = 3
            // i = 0, r = 0, c = 0,  1, => 1
            // i = 1, r = 0, c = 1,  2, => mat[0,1] = 2, mat[1][0] = 4
            // i = 2, r = 0, c = 2,  3, => mat[0,2] = 3, mat[1][1] = 5, mat[2][0] = 7
            // i = 3, r = 1, c = 3,  6, => 8
            int r = i < M ? 0 : i - M + 1;
            int c = i < M ? i : M - 1;

            System.out.println("r = " + r + ", c = " + c + ", mat[r][c] = " + mat[r][c]);

            while (r < N && c > -1) {
                System.out.println("mat["+r+"]["+c+"] = " + mat[r][c]);
                intermediate.add(mat[r][c]);
                ++r;
                --c;
            }

            System.out.println("===================");

            //rotate
            if (i % 2 == 0) {
                Collections.reverse(intermediate);
            }

            for (int j = 0; j < intermediate.size(); j++) {
                result[k++] = intermediate.get(j);
            }
        }

        return result;
    }

    /**
     * 561. 数组拆分 I
     * https://leetcode-cn.com/problems/array-partition-i/
     *
     * 1. 数组升序排序
     * 2. 相邻两数求最小值，
     * 3. 最小值累加,既求得min(a,b)总和最大
     *
     * @param nums
     * @return
     */
    public int arrayPairSum(int[] nums) {

        Arrays.sort(nums);

        int len = nums.length;
        int i = 0;
        int j = 1;
        int sum = 0;

        while(j < len-1) {
            int a = nums[i];
            int b = nums[j];
            sum+= Math.min(a, b);
            i++;
            j++;
        }
        return sum;
    }

    /**
     * 724. 寻找数组的中心下标
     * https://leetcode-cn.com/problems/find-pivot-index/
     *
     * @param nums
     * @return
     */
    public int pivotIndex(int[] nums) {

        int index = -1;
        int len = nums.length-1;
        for (int i = 0; i <= len; i++) {

            System.out.println("i = " + i);
            //计算左边的值
            int lSum = 0;
            int ll = 0;
            while(ll < i) {
                System.out.println("nums[ll] = " + nums[ll]);
                lSum+=nums[ll];
                ll++;
            }

            //计算右边的值
            int rSum = 0;
            int rr = len;
            while(rr>i) {
                System.out.println("nums[rr] = " + nums[rr]);
                rSum += nums[rr];
                rr--;
            }

            System.out.println("len="+len+",i="+i+",lSum = " + lSum + ",rSum = " + rSum);
            if (rSum == lSum) {
                return i;
            }
        }

        return index;
    }

    /**
     * 面试题 01.08. 零矩阵
     * https://leetcode-cn.com/problems/zero-matrix-lcci/
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {

        int m = matrix.length, n = matrix[0].length;
        boolean[] row = new boolean[m], col = new boolean[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * 面试题 01.07. 旋转矩阵
     * https://leetcode-cn.com/problems/rotate-matrix-lcci/
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {

        //数组长度
        int n = matrix.length;

        //生命一个同样大小的矩阵数组
        int[][] newMatrix = new int[n][n];

        //观察旋转规律，旋转后新的位置为 n - row -i
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                newMatrix[j][n-i-1] = matrix[i][j];
            }
        }

        //旋转后的矩阵，替换原矩阵
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix[i][j] = newMatrix[i][j];
            }
        }
    }



}
