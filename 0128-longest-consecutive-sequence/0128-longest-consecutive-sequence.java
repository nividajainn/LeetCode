class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums) set.add(num); //set me saare element daalo unique hi add hoge
        
        int maxSeq = 0; //seq dekhne

        for(int n : set){  //ek ek number lo set se
            if(!set.contains(n-1)){ //dekho uss number ke pehle ka koi exist to nhi krta 
            int currSum = n; //nhi krta hoga to wo number se shuru kro
            int length = 1; 

                while(set.contains(currSum+1)){ 
                //jab tak aage ke number hoge 1 ke baad 2 ese tab tak length badhao
                    
                    currSum++;
                    length++;
                }

                maxSeq = Math.max(maxSeq, length); //maxSeq me add karo or dekho sabse jyda kya hai
            }
            
        }
        return maxSeq;
    }
}