package com.ad.sorting;

import com.ad.utils.PrintUtils;

public class MergeSort {

    public void sort(int[] nums) {

        mergeSort(nums, 0, nums.length-1);
    }

    private void mergeSort(int[] nums, int left, int right) {

        //System.out.printf("left:" + left + ", right:"+right+"\n");

        if (left < right) {
            int mid = (left+right) / 2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid+1, right);

            //开始合并
            merge(nums,left,right,mid);
        }
    }

    private void merge(int[] nums, int left, int right, int mid) {

        int[] tmp = new int[nums.length];
        int p1 = left; //左边第一个数
        int p2= mid+1; //右边第一个数位置
        int loc = left; //保存当前的数，到tmp中

        while(p1 <= mid && p2 <= right) {
            if (nums[p1] <= nums[p2]) { //左边数 小于右边
                tmp[loc] = nums[p1];
                p1++;
                loc++;
            } else {
                tmp[loc] = nums[p2];
                p2++;
                loc++;
            }
        }

        while(p1 <= mid) {
            tmp[loc++] = nums[p1++];
        }
        while(p2 <= right) {
            tmp[loc++] = nums[p2++];
        }

        for (int i=left; i<=right; i++) {
            nums[i] = tmp[i];
        }
    }
}
