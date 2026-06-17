class Solution {

    public String getPermutation(int n, int k) {

        List<Integer> nums = new ArrayList<>();

        int fact = 1;

        // Numbers 1 to n
        for(int i = 1; i < n; i++) {
            fact *= i;
            nums.add(i);
        }

        nums.add(n);

        // Convert to 0-based indexing
        k--;

        StringBuilder ans = new StringBuilder();

        while(true) {
            // Select index

            int idx = k / fact;
            ans.append(nums.get(idx));
            nums.remove(idx);
            
            // Last number left
            if(nums.size() == 0) {

                break;
            }

            // Update k
            k = k % fact;

            // Update factorial
            fact = fact / nums.size();
        }

        return ans.toString();
    }
}