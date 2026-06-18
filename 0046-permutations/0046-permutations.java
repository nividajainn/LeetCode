class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        boolean used[] = new boolean[nums.length];

        backtrack(nums, new ArrayList<>(), used);

        return ans;
    }

    public void backtrack(int[] nums, List<Integer> curr, boolean[] used) {

        // Agar current permutation complete ho gayi
        if(curr.size() == nums.length){

            // Deep copy banao
            ans.add(new ArrayList<>(curr));

            return;
        }

        // Har element ko try karo
        for(int i=0;i<nums.length;i++){

            // Agar pehle use ho chuka hai
            if(used[i])
                continue;

            // Choose
            curr.add(nums[i]);
            used[i] = true;

            // Explore
            backtrack(nums,curr,used);

            // Undo (Backtrack)
            curr.remove(curr.size()-1);
            used[i] = false;
        }
    }
}