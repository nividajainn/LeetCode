class Solution {
    public void setZeroes(int[][] matrix) {
        // Number of rows
        int m = matrix.length;

        // Number of columns
        int n = matrix[0].length;

        // Store which rows need to be made zero
        boolean[] rows = new boolean[m];

        // Store which columns need to be made zero
        boolean[] cols = new boolean[n];

        // First pass: find all zeros
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // If current cell is 0
                if (matrix[i][j] == 0) {

                    // Mark this row
                    rows[i] = true;

                    // Mark this column
                    cols[j] = true;
                }
            }
        }

        // Second pass: update matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                // If row or column is marked
                if (rows[i] || cols[j])
                matrix[i][j] = 0;
            }
        }
    }
}
