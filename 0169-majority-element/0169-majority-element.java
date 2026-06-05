class Solution {
    public int majorityElement(int[] nums) {
      int candidate = 0, count = 0;

      for(int num : nums){
       
        // Agar count 0 ho gaya
        // to naya candidate choose karo
            if (count == 0) {
            candidate = num;
            }

            // Same candidate mila to vote badhao
            if (num == candidate) {
                count++;
            }
            
            // Different mila to vote ghatao
            else {
                count--;
            }
       }
       return candidate;
    }
}

 /*
    Majority element appears more than n/2 times.
    
    After sorting, Arrays.sort(nums);
    majority element will always be present return nums[n/2];
    at middle index.
 */