class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0,high = 0;
        for(int num : nums)
        {
            low = Math.max(low,num);
            high += num;
        }
        int res = high;
        while(low <= high)
        {
            int mid = low+(high-low)/2;
            if(isValid(nums,k,mid))
            {
                res = mid;
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        return res;
    }
    static boolean isValid(int []nums,int k,int mid)
    {
        int count = 1;
        int sum = 0;
        for(int i=0;i<nums.length;i++)
        {
            sum += nums[i];
            if(sum > mid)
            {
                sum = nums[i];
                count++;
            }
        }
        return count <= k;
    }
}