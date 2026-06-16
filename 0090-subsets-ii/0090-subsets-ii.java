class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        // Sort so that duplicates come together
        Arrays.sort(nums);

        backtrack(0, nums, new ArrayList<>());

        return ans;
    }

    public void backtrack(int start, int[] nums, List<Integer> curr) {

        // Add current subset to answer
        ans.add(new ArrayList<>(curr));

        for(int i = start; i < nums.length; i++) {

            // Skip duplicates at same recursion level
            if(i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            // Take current element
            curr.add(nums[i]);

            // Recursive call for next index
            backtrack(i + 1, nums, curr);

            // Backtrack (remove last added element)
            curr.remove(curr.size() - 1);
        }
    }
}