class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0]; //first wale ko maxSum maan lo
        int currSum = 0;  //ek sum count karne ke liye
        
        //
        for(int i=0; i<nums.length; i++){
            currSum += nums[i]; //currsum me number add krte rho 

            maxSum = Math.max(maxSum, currSum); //or dekhte rho ko maxsum kaha aa rha

            if(currSum < 0) currSum = 0; //agar -ve me aaya to 0 kar do 
        }

        return maxSum;
    }
}