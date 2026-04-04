class Solution {
    public int climbStairs(int n) {

        // agar 1 ya 2 steps hain to direct answer
        if (n <= 2) return n;

        // prev2 → ways to reach step (i-2)
        int prev2 = 1;  // step 1 ke ways

        // prev1 → ways to reach step (i-1)
        int prev1 = 2;  // step 2 ke ways

        // loop 3rd step se start hota hai
        for (int i = 3; i <= n; i++) {

            // current step ke ways = last 2 steps ka sum
            int curr = prev1 + prev2;

            // values shift karte hain:
            // ab prev2 banega old prev1
            prev2 = prev1;

            // aur prev1 banega current
            prev1 = curr;
        }

        // final answer last computed value me hota hai
        return prev1;
    }
}