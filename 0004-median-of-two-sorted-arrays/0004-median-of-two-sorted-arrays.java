class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int i=0, j=0, k=0;
        
        int [] arr = new int[n+m];
         
        while(i < n && j < m){
            if(nums1[i] <= nums2[j]){
                arr[k++] = nums1[i++];
            }
            else{
                arr[k++] = nums2[j++];
            }
        }

        while(i < n){
            arr[k++] = nums1[i++];
        }

        while(j < m){
            arr[k++] = nums2[j++];
        }

       int size = n + m;

        if(size % 2 == 1){

            return arr[size/2];
        }

        return (arr[size/2] + arr[size/2 - 1]) / 2.0;
    }
}