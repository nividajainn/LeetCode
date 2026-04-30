class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = firstIndex(nums, target);
        int last = lastIndex(nums, target);
        return new int[]{first, last};
        }
      private int firstIndex(int[] nums, int target){  
        int start = 0;
        int end = nums.length-1;
        int result = -1;

        while(start<=end){
            int mid = start+(end-start)/2;

            if(nums[mid] == target){ result = mid; 
            end = mid-1;
            } //mid ke pehle wale me end ko le aayenge
              else if(nums[mid]<target){
              start = mid+1;
            } //target bada h to start mid+1 me aa jayega
              else end = mid-1;
        }
        return result; 
      } 

           private int lastIndex(int[] nums, int target){  
        int start = 0;
        int end = nums.length-1;
        int result = -1;

        while(start<=end){
            int mid = start+(end-start)/2;

            if(nums[mid] == target){
                 result = mid; 
            start = mid+1; //mid ke baad wale me start ko le aayenge
            }
              else if(nums[mid]<target){
              start = mid+1; //target bada h to start mid+1 me aa jayega
             }
              else end = mid-1;
        } 
        return result; 
}}