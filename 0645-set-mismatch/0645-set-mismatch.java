class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int [] freq = new int[n+1];

        // Har number ki frequency count karo
        for (int num : nums) {
            freq[num]++;
        }

        int repeating = -1;
        int missing = -1;

        // 1 se n tak check karo
        for (int i = 1; i <= n; i++) {

            // Frequency 2 hai to repeating number
            if (freq[i] == 2) {
                repeating = i;
            }

            // Frequency 0 hai to missing number
            if (freq[i] == 0) {
                missing = i;
            }
        }

        return new int[]{repeating, missing};
    }
}