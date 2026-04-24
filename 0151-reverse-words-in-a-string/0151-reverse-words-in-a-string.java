class Solution {
    public String reverseWords(String s) {
        String[] sp = s.trim().split("\\s+");
        String ans = "";

        for(int i=sp.length-1; i>0; i--){
            ans += sp[i]+" ";
        }

        return ans + sp[0];
    }
}