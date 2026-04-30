class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;

            // make mid even
            if (mid % 2 == 1) mid--;

            if (nums[mid] == nums[mid + 1]) {
                low = mid + 2;   // single element right side
            } else {
                high = mid;      // single element left side (including mid)
            }
        }

        return nums[low];
    }
}