class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<String> set = new HashSet<>();

        for (int num : arr1) {
            String s = String.valueOf(num);
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                sb.append(c);
                set.add(sb.toString());
            }
        }

        int ans = 0;

        for (int num : arr2) {
            String s = String.valueOf(num);
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                sb.append(c);
                if (set.contains(sb.toString())) {
                    ans = Math.max(ans, sb.length());
                }
            }
        }

        return ans;
    }
}