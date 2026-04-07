class Solution {
    public int[] findErrorNums(int[] nums) {
         Arrays.sort(nums);

        int dup = -1, missing = -1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                dup = nums[i];
            }
        }

        // missing find
        for (int i = 1; i <= nums.length; i++) {
            boolean found = false;

            for (int num : nums) {
                if (num == i) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                missing = i;
                break;
            }
        }

        return new int[]{dup, missing};
    }
}