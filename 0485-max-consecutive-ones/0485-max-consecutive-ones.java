class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, count = 0;

        for(int n : nums){
            if(n == 1){ //agar 1 dikhe to count badhao
                count++;
               max = Math.max(max, count); //maximun dekhte rho 
            }
            else{
                count = 0; //ek bhi dusra number aaye to count 0 se start krenge
            }
        }

        return max; 
    }
}