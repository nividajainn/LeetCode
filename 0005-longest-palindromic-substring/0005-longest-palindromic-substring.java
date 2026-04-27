class Solution {

    public String longestPalindrome(String s) {

        String ans = "";

        for (int i = 0; i < s.length(); i++) {

            // odd length
            String p1 = expand(s, i, i);

            // even length
            String p2 = expand(s, i, i + 1);

            // take longest
            if (p1.length() > ans.length()) ans = p1;
            if (p2.length() > ans.length()) ans = p2;
        }

        return ans;
    }

    public String expand(String s, int left, int right) {

        while (left >= 0 && right < s.length() &&
               s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        // return palindrome substring
        return s.substring(left + 1, right);
    }
}