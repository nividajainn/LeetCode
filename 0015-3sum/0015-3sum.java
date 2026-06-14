class Solution {

    public List<List<Integer>> threeSum(int[] nums) {

        // Final answer store karne ke liye
        List<List<Integer>> ans = new ArrayList<>();

        // Array ko sort kar do
        Arrays.sort(nums);

        int n = nums.length;

        // Har element ko ek baar fix karenge
        for(int i = 0; i < n - 2; i++) {

            // Duplicate fixed element skip karo
            // [-1,-1,0,1]
            // Agar dono -1 se start karenge to same answer aayega
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Two pointers
            int left = i + 1;
            int right = n - 1;

            while(left < right) {

                // Current triplet ka sum
                int sum = nums[i] + nums[left] + nums[right];

                // Agar sum 0 hai to answer mil gaya
                if(sum == 0) {
                    ans.add(Arrays.asList( 
                        nums[i], nums[left], nums[right] ));

                    left++;
                    right--;

                    // Left side duplicates skip karo
                    // Example:
                    // [-2,0,0,0,2]

                    while(left < right &&
                          nums[left] == nums[left - 1]) {

                        left++;
                    }

                    // Right side duplicates skip karo
                    while(left < right &&
                          nums[right] == nums[right + 1]) {

                        right--;
                    }
                }
                
                else if(sum < 0) {   //Sum chhota hai Hume bada sum chahiye

                    left++;
                }
                else {         //Sum bada hai Hume chhota sum chahiye
                    right--;
                }
            }
        }
        return ans;
    }
}