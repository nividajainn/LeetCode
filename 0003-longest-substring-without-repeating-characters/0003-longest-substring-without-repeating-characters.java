class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();

        int left = 0, maxLen = 0; 

        for(int right=0; right< s.length(); right++){ 
            while(set.contains(s.charAt(right))){ //jab tak set me right character hai
                set.remove(s.charAt(left)); //tab tak left wale character ko remove kro
                left++;
            }

            set.add(s.charAt(right)); //nahi to add karo set me

            maxLen = Math.max(maxLen, right-left+1); 
            //Current window ki length (right - left + 1) aur previous maximum length me se jo bada ho, use maxLen me store karo.
        }
        return maxLen;
    }
}