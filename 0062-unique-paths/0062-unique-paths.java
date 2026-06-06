class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        
        // First column:
        // Robot can only move DOWN, so every cell has 1 path
        for(int i=0; i<m; i++){
            dp[i][0] = 1;
        }
        
        // First row:
        // Robot can only move RIGHT, so every cell has 1 path
        for(int j=0; j<n; j++){
            dp[0][j] = 1;
        }

        // Fill remaining cells
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {

                // Ways from TOP + Ways from LEFT
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        // Bottom-right cell contains total unique paths
        return dp[m-1][n-1];
    }
}