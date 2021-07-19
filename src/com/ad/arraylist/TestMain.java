package src.com.ad.arraylist;

public class TestMain {

    public static void main(String[] args) {

        int[][] nums = new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        ArrayListSolution solution = new ArrayListSolution();

        int[] prices = new int[]{7,6,4,3,1};

        int[] testNums = new int[]{-1,-1,0,1,1,0};

        int index = solution.pivotIndex(testNums);
        System.out.println("index = " + index);
    }
}
