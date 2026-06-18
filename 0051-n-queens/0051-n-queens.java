class Solution {
   List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        boolean[] col = new boolean[n];
        boolean[] leftDiag = new boolean[2*n-1];
        boolean[] rightDiag = new boolean[2*n-1];

        backtrack(0, n, board, col, leftDiag, rightDiag);
        return ans;
    }

    void backtrack(int row, int n, char[][] board, boolean[] col, boolean[] leftDiag,boolean[] rightDiag){
        
        // Base Case
        if(row==n){
            List<String> curr = new ArrayList<>();

            for(int i=0;i<n;i++){
                curr.add(new String(board[i]));
            }

            ans.add(curr);
            return;
        }

        for(int c=0;c<n;c++){

         int ld = row-c+n-1;
            int rd = row+c;

            // Unsafe
           if(col[c] || leftDiag[ld] || rightDiag[rd]){
                continue;
            }

            // Place Queen
            board[row][c]='Q';

            col[c]=true;
            leftDiag[ld]=true;
            rightDiag[rd]=true;

            // Next Row
            backtrack(row+1, n, board, col, leftDiag, rightDiag);

            // Backtrack
            board[row][c]='.';

            col[c]=false;

            leftDiag[ld]=false;
            rightDiag[rd]=false;
        }
    }
} 