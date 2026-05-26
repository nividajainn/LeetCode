class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int complement = target-nums[i];

            //agar num hoga map me to hum wo return kara denge 
            if (map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            }
            //nahi hoga to daal denge aage check ke liye
            else {
                map.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException("No match");
     }
}