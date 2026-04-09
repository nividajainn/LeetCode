class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int zeroCount = 0;
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++) {
            
            // agar current element 0 hai to zero count badhao
            if (nums[right] == 0) {
                zeroCount++;
            }

            // agar allowed zeroes se zyada ho gaye to window chhoti karo
            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            // current valid window ka length nikal lo
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}