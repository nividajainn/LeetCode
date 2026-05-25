class Solution {
    
    public int singleNumber(int[] nums) {
        
        // XOR stores final unique number
        int ans = 0;
        
        // traverse all elements
        for(int i = 0; i < nums.length; i++) {
            
            /*
            XOR properties:
            a ^ a = 0
            a ^ 0 = a
            So duplicate numbers cancel each other.
            
            Example:
            [2,2,1]
            0 ^ 2 = 2
            2 ^ 2 = 0
            0 ^ 1 = 1
            Final answer = 1
            */
            
            ans ^= nums[i];
        }
        
        // remaining number is the single number
        return ans;
    }
}