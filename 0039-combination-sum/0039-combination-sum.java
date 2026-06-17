class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        backtrack(0, candidates, target, new ArrayList<>());

        return ans;
    }

    public void backtrack(int i, int[] candidates, int target, List<Integer> curr){

        // Target achieved
        if(target == 0){
            ans.add(new ArrayList<>(curr));
            return;
        }

        // Out of bounds
        if(i == candidates.length){
            return;
        }

        // Take current element
        if(candidates[i] <= target){
            curr.add(candidates[i]);

            backtrack(i, candidates, target - candidates[i], curr );
            curr.remove(curr.size()-1);
        }

        // Not Take
        backtrack(i+1, candidates, target, curr);
    }
}