class Solution {
    private int calculateSum(int[] nums, int divisor, int threshold){
        int total = 0;
        for(int i =0; i<nums.length; i++){
            total += ( nums[i] + divisor - 1 ) / divisor;
        }
        return total;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int start = 1;
        int end = 0;
        for(int i= 0; i<nums.length; i++){
            end = Math.max(end, nums[i]);
        }
        int ans = 0;
        while(start <= end){
            int mid = start + (end - start)/2;

            int sum = calculateSum(nums, mid, threshold);
            if(sum <= threshold){
                ans = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return ans;
    }
}