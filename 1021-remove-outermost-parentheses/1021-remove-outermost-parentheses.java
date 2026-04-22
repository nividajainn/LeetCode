class Solution {
    public String removeOuterParentheses(String s) {  
        StringBuilder ans = new StringBuilder();
        int open = 0;  // count of '(' brackets

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i); // current character

            // agar '(' mila
            if (ch == '(') {
                // agar ye outer nahi hai (already inside hai)
                if (open > 0) {
                    ans.append(ch); // add karo
                }
                open++; // open bracket count badhao
            }
            // agar ')' mila
            else {
                open--; // pehle count kam karo
                
                // agar ye outer nahi hai
                if (open > 0) {
                    ans.append(ch); // add karo
                }
            }
        }
        return ans.toString();
    }
}