class Solution {

    public void solveSudoku(char[][] board) {

        solve(board);
    }

    boolean solve(char[][] board) {

        for (int r = 0; r < 9; r++) {

            for (int c = 0; c < 9; c++) {

                if (board[r][c] == '.') {

                    for (char ch = '1'; ch <= '9'; ch++) {

                        if (isValid(board, r, c, ch)) {

                            board[r][c] = ch; // place

                            if (solve(board))
                                return true;

                            board[r][c] = '.'; // backtrack
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    boolean isValid(char[][] board, int r, int c, char ch) {

        for (int i = 0; i < 9; i++) {

            // Row
            if (board[r][i] == ch) return false;

            // Column
            if (board[i][c] == ch) return false;

            // 3x3 Box
            int row = 3 * (r / 3) + i / 3;
            int col = 3 * (c / 3) + i % 3;

            if (board[row][col] == ch) return false;
        }
        return true;
    }

}