package src.com.ad.sorting;

import com.ad.utils.PrintUtils;

import java.util.Arrays;

public class TestMain {
    public static void main(String[] args) {

        int[] nums = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};


//        MergeSort mergeSort = new MergeSort();
//        mergeSort.sort(nums);

        Sorts s = new Sorts();

        int ans = s.binarySearch(nums, 1);
        System.out.println("ans = " + ans);
//        s.quickSort(nums);
//
//        String res = PrintUtils.printArray(nums);
//        System.out.printf("" + res);
    }
}
