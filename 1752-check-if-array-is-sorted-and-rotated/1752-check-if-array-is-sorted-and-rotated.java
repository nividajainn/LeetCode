class Solution {
    public boolean check(int[] nums) {

        // count batayega ki array me order kitni baar break hua
        // order break ka matlab: previous element next element se bada hai
        int count = 0;
        int n = nums.length;

        // har adjacent pair ko compare karo
        // nums[i] aur nums[i + 1]
        for (int i = 0; i < n - 1; i++) {

            // agar current element next element se bada hai
            // to sorted order yaha break ho gaya
            if (nums[i] > nums[i + 1]) {
                count++;
            }
        }

    // rotation check ke liye last element aur first element bhi compare karna zaruri hai
        // kyunki rotated array circular form me hota hai
        if (nums[n - 1] > nums[0]) {
            count++;
        }

        // sorted and rotated array me maximum 1 break allowed hota hai
        // agar count 0 hai → already sorted
        // agar count 1 hai → sorted + rotated
        // agar count > 1 hai → valid nahi
        return count <= 1;
    }
}