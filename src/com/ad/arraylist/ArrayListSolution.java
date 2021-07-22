package src.com.ad.arraylist;

import com.ad.utils.PrintUtils;

import java.util.*;

public class ArrayListSolution {

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
