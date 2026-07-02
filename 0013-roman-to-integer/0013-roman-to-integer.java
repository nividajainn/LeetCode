class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        char chars[] = s.toCharArray(); //given string to array 
        int result = map.get(chars[chars.length-1]);
        
         //i j pointer 0 or 1 me 
         for(int i=chars.length-2 ; i>=0 ;i--){
            //agar i bada hoga j se to add karenge
            if(map.get(chars[i])< map.get(chars[i+1])){
                result = result - map.get(chars[i]);
            }
            //nahi to sub
            else{
                result = result + map.get(chars[i]);
            }
         }
        //  //or baki ko add kar do
        //  result += map.get(chars[i]);

         return result;
    }
}
//time and space complexity is O(n)
//TC coz iterating through the ip string
//SC using hashmap