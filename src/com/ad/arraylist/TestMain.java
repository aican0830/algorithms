package src.com.ad.arraylist;

public class TestMain {

    public static void main(String[] args) {

        int[][] nums = new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{6,9,5,26,18}};
        ArrayListSolution solution = new ArrayListSolution();

//        int[] prices = new int[]{7,6,4,3,1};
//
//        int[] testNums = new int[]{-1,-1,0,1,1,0};
//
//        int index = solution.pivotIndex(testNums);
//        System.out.println("index = " + index);

        int[][] mat = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
//        int n = nums.length;
//        for (int i = 0; i < n; ++i) {
//            System.out.println("");
//            for (int j = 0; j < n; ++j) {
//                System.out.print("        \ti="+i+",j="+j+",nums[i][j] = " + nums[i][j]);
//            }
//        }
        solution.findDiagonalOrder(mat);

//        for (int i = 0; i < n; ++i) {
//            System.out.println("");
//            for (int j = 0; j < n; ++j) {
//                System.out.print(" \trotate="+(n-i-1)+", i="+i+",j="+j+",nums[i][j] = " + nums[i][j]);
//            }
//        }
    }
}
