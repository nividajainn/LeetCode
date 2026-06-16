class Solution {
    public int findContentChildren(int[] g, int[] s) {

        //hume yaha dekhna hai kitne child satisfy ho sakte h cookies se
        //uss number wale child ko ya to utni milegi ya usse jyda kam nhi milni chahiye

        Arrays.sort(g); 
        Arrays.sort(s);

        int i = 0, j = 0, count = 0;
        
        while(i < g.length && j < s.length){
            
            if(s[j] >= g[i]){ //cookie >= child
                count++;
                i++;
                j++;
            }
            else{
                j++;
            }
        }
        return count;
    }
}