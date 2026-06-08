import java.util.*;

class Solution {
    public int findMaxLength(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, -1); // prefix sum 0 at index -1

        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {

            // convert 0 -> -1, 1 -> +1
            sum += (nums[i] == 0) ? -1 : 1; //agar 0 to -1 add karo warna 1 add karo

            // if same sum seen before → update length
            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i); // store first occurrence only
            }
        }

        return maxLen;
    }
}