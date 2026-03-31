import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] result = new int[n];

        // Stack stores indices of days
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            // Jab current temp zyada ho previous se
            while (!stack.isEmpty() && 
                   temperatures[i] > temperatures[stack.peek()]) {

                int prevIndex = stack.pop();

                // difference of days
                result[prevIndex] = i - prevIndex;
            }

            // current index push karo
            stack.push(i);
        }

        return result;
    }
}