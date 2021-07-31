package src.com.ad.binarysearch;

public class BinarySearch {

    /**
     * 起始条件 l = 0, r = length-1;
     * 终止： l > r
     * 向左搜索: 0, mid - 1
     * 向右搜索：mid + 1, n
     *
     * @param nums sorted array
     * @param target search element
     * @return
     */
    int search1(int[] nums, int target) {

        if (nums == null || nums.length == 0) return -1;
        int l = 0, r = nums.length - 1;

        while(l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }


    /**
     * 起始条件：l = 0, r = length
     * 终止条件：l = r
     * 向左搜索: 0, mid
     * 向右搜索: mid+1, n
     *
     * @param nums sorted array
     * @param target search element
     * @return
     */
    int search2(int[] nums, int target) {

        if(nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length;
        while(left < right){
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){ return mid; }
            else if(nums[mid] < target) { left = mid + 1; }
            else { right = mid; }
        }

        // Post-processing:
        // End Condition: left == right
        if(left != nums.length && nums[left] == target) return left;
        return -1;
    }

    /**
     * 起始条件：l = 0, r = length-1
     * 终止条件：l+1 = r
     * 向左搜索: 0, mid
     * 向右搜索: mid, n
     *
     * @param nums sorted array
     * @param target search element
     * @return
     */
    int search3(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length - 1;
        while (left + 1 < right){
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }

        System.out.println("left = " + left + ",right = " + right);

        // Post-processing:
        // End Condition: left + 1 == right
        if(nums[left] == target) return left;
        if(nums[right] == target) return right;
        return -1;
    }
}
