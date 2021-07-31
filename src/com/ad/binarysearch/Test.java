package src.com.ad.binarysearch;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{4,5,6,7,0,1,2};
        int target = 0;

//        int ret = solution.searchInRotatedSortedArray(nums, target);


        BinarySearch bs = new BinarySearch();
        int ret = bs.search3(new int[]{1,2,3,4,5,6,7,8}, 1);
        System.out.println("ret = " + ret);


    }
}
