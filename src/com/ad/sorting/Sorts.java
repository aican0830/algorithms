package src.com.ad.sorting;

import com.ad.utils.PrintUtils;

public class Sorts {

    public int binarySearch2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) >>> 1;
            System.out.println("mid = " + mid);
            if(nums[mid] < target) {
                left = mid + 1;
            }else if(nums[mid] > target) {
                right = mid - 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 二分查找
     *
     * @param nums
     * @param target
     */
    public int binarySearch(int[] nums, int target) {

        int targetIndex = -1;
        if (nums.length == 0) return targetIndex;

        int n = nums.length;
        int low = 0, high = n;

        // 1,2,3,4,5,6,7,8
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (target == nums[mid]) {
                targetIndex = mid;
                break;
            } else if (target > nums[mid]) {
                //low = 5;
                low = mid+1;
            } else if (target < nums[mid]) {
                high = mid;
            }
            System.out.println("target = "+target+", mid = " + mid+", nums[mid] = " + nums[mid] +",low = " + low + ",high = " + high);
        }


        return targetIndex;
    }

    /**
     * 冒泡排序
     *
     * @param nums
     */
    public void bubbleSort(int[] nums) {

        for (int i = nums.length - 1; i > 0; i--) {
            int last  = 1;
            for (int j = 1; j <= i; j++) {

                if (nums[j-1] > nums[j]) {
                    int tmp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = tmp;
                    last = j;
                }
            }
            i = last;

            System.out.printf("" + last+"_");

        }
    }

    public void shellSort(int[] nums) {

        int len = nums.length;
        int step = len;

        while(step >= 1) {

            step = step/2;
            System.out.printf("" + step);
            for (int i = step; i < len; i++) {
                for (int j = i; j - step >= 0; j-=step) {

                    if (nums[j-step] > nums[j]) {
                        int tmp = nums[j-step];
                        nums[j-step] = nums[j];
                        nums[j] = tmp;
                    } else {
                        break;
                    }
                }
            }
        }
    }

    public void quickSort(int[] nums) {

        String res = PrintUtils.printArray(nums);
        System.out.println("原 数组："+res);
        qSort(nums, 0, nums.length-1);
    }

    private void qSort(int[] nums, int left, int right) {

        if (left >= right) return;

        int base = nums[left];
        int ll = left;
        int rr = right;

        System.out.println("base="+base+"得排序结果");
        while (ll < rr) {

            while(ll < rr && nums[rr] >= base) {
               rr--;
            }

            if (ll < rr) {
                swap(nums,ll, rr);
                System.out.println("从右边往左交换"+PrintUtils.printArray(nums));

                ll++;
            }

            while(ll<rr && nums[ll] <= base) {
               ll++;
            }
            if (ll < rr) {
                swap(nums,ll, rr);
                System.out.println("从左边往右交换"+PrintUtils.printArray(nums));
                rr--;
            }
        }

        if (ll > left) {
            qSort(nums, left, ll-1);
        }
        if (rr < right) {
            qSort(nums, ll+1, right);
        }
    }

    private void swap(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }
}
