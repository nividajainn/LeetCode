class Solution {
    public int maxDepth(String s) {
        int currentDepth = 0;   // abhi kitne parentheses open hain
        int maxDepth = 0;       // maximum depth store karne ke liye

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                currentDepth++; // ek naya bracket open hua
                maxDepth = Math.max(maxDepth, currentDepth);
            } 
            else if (ch == ')') {
                currentDepth--; // ek bracket close hua
            }
        }

        return maxDepth;
    }
}