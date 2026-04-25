class Solution {
    public String frequencySort(String s) {

        int[] freq = new int[128];

        // Step 1: count frequency
        for (char ch : s.toCharArray()) {
            freq[ch]++;
        }

        StringBuilder ans = new StringBuilder();

        // Step 2: max frequency nikalte raho
        while (true) {

            int max = 0;
            char ch = 0;

            // find max freq char
            for (int i = 0; i < 128; i++) {
                if (freq[i] > max) {
                    max = freq[i];
                    ch = (char) i;
                }
            }

            if (max == 0) break; // sab khatam

            // Step 3: add max char
            for (int i = 0; i < max; i++) {
                ans.append(ch);
            }

            freq[ch] = 0; // mark used
        }

        return ans.toString();
    }
}