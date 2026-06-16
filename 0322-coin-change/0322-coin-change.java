class Solution {

    public int coinChange(int[] coins, int amount) {

        // dp[i] = minimum coins needed to make amount i
        int[] dp = new int[amount + 1];

        // Fill with a large value
        Arrays.fill(dp, amount + 1);

        // Base case
        dp[0] = 0;

        // Calculate answer for every amount from 1 to amount
        for(int i = 1; i <= amount; i++) {

            // Try every coin
            for(int coin : coins) {

                // Coin can be used
                if(coin <= i) {

                    dp[i] = Math.min(
                            dp[i],
                            1 + dp[i - coin]
                    );
                }
            }
        }

        // If amount cannot be formed
        if(dp[amount] == amount + 1) {
            return -1;
        }

        return dp[amount];
    }
}