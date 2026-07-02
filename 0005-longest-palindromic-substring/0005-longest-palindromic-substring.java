class Solution {

    public String longestPalindrome(String s) {

        // Stores the longest palindrome found
        String ans = "";

        // Choose starting index
        for (int i = 0; i < s.length(); i++) {

            // Choose ending index
            for (int j = i; j < s.length(); j++) {

                // Get current substring
                String sub = s.substring(i, j + 1);

                // If it is palindrome and longer than previous answer
                if (isPalindrome(sub) && sub.length() > ans.length()) {
                    ans = sub;
                }
            }
        }

        // Return longest palindrome
        return ans;
    }

    // Function to check palindrome
    public boolean isPalindrome(String str) {

        int left = 0;
        int right = str.length() - 1;

        // Compare characters from both ends
        while (left < right) {

            // Not palindrome
            if (str.charAt(left) != str.charAt(right))
                return false;

            left++;
            right--;
        }

        // Palindrome
        return true;
    }
}