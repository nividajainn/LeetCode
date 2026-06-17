class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        // Pehle sort kar lo taki duplicates ek sath aa jaye
        Arrays.sort(candidates);

        backtrack(0, candidates, target, new ArrayList<>());

        return ans;
    }

    public void backtrack(int start, int[] candidates, int target, List<Integer> curr) {

        // Agar target 0 ho gaya to valid combination mil gaya
        if(target == 0) {

            ans.add(new ArrayList<>(curr));

            return;
        }

        // Start se end tak loop chalao
        for(int i = start; i < candidates.length; i++) {

            // Same recursion level pe duplicate ko skip karo
            if(i > start && candidates[i] == candidates[i - 1]) {

                continue;
            }

            // Agar current number target se bada hai
            // to aage wale bhi bade hi honge (sorted array)
            if(candidates[i] > target) {

                break;
            }

            // Current element choose karo
            curr.add(candidates[i]);

            // i+1 bhejna hai kyuki ek element sirf ek baar use ho sakta hai
            backtrack( i + 1, candidates, target - candidates[i], curr );

            // Backtracking:
            // Jo element add kiya tha use hata do
            // taki next possibilities try kar sake
            curr.remove(curr.size() - 1);
        }
    }
}