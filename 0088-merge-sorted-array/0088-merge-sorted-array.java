class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;  //pointer for nums1 array's element
        int j = n-1;  //pointer for muns2 array    
        int k = m+n-1; //pointer for positioning

        while(i>=0 && j>=0){
            if(nums1[i] > nums2[j]){ //agar i ka ele bada h to 
                nums1[k--] = nums1[i--]; //0 ki jagha wo number daalo bada wala
            }

            else{
                nums1[k--] = nums2[j--]; //nahi to j ka bada ho to ye rakho
            }
        }

        while(j >= 0){ //or agar koi element bach jata h nums2 me to usko add kr do
            nums1[k--] = nums2[j--]; 
        }
    }
}