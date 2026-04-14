import java.util.*;

class Solution {
    public int firstMissingPositive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        //sab elements set me daalo
        for (int num : nums) {
            set.add(num);
        }

        //1 se check start karo
        int i = 1;

        while (true) {
            //koi element 1 2 3... missing mile 
            if (!set.contains(i)) {
                return i; //wo return kar do 
            }
            i++; //i mtlb 1++, 2++ esa hote jayega
        }
    }
}