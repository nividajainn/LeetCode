class Solution {

    public String longestPalindrome(String s) {

        // If string is empty, return empty string
        if (s == null || s.length() == 0)
            return "";

        // Store starting and ending index of longest palindrome
        int start = 0;
        int end = 0;

        // Try every character as the center
        for (int i = 0; i < s.length(); i++) {

            // Check odd-length palindrome (e.g. "racecar")
            int len1 = expand(s, i, i);

            // Check even-length palindrome (e.g. "abba")
            int len2 = expand(s, i, i + 1);

            // Take the longer palindrome
            int len = Math.max(len1, len2);

            // If current palindrome is longer than previous answer
            if (len > end - start + 1) {

                // Calculate starting index
                start = i - (len - 1) / 2;

                // Calculate ending index
                end = i + len / 2;
            }
        }

        // Return the longest palindromic substring
        return s.substring(start, end + 1);
    }

    // Expand from the given center and return palindrome length
    public int expand(String s, int left, int right) {

        // Keep expanding while:
        // 1. Indices are inside the string
        // 2. Characters on both sides are equal
        while (left >= 0 &&
               right < s.length() &&
               s.charAt(left) == s.charAt(right)) {

            left--;
            right++;
        }

        // Actual palindrome length
        // Example:
        // left = -1, right = 3
        // Length = 3 - (-1) - 1 = 3
        return right - left - 1;
    }
}