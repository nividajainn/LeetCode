class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
      
      //num ki frequency ko 1 se increase karo (agar pehle nahi hai to 0 se start karo)
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: list of unique elements
        List<Integer> list = new ArrayList<>(map.keySet());

        // Step 3: sort based on frequency (high to low)
        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));

        // Step 4: pick first k elements
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}