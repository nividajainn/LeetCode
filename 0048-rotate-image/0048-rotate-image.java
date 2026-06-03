class Solution {
    public void rotate(int[][] matrix) {

        int n = matrix.length;

        // Step 1: Matrix ka transpose karo
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Har row ko reverse karo
        for (int i = 0; i < n; i++) {

            int left = 0;
            int right = n - 1;

            while (left < right) {

                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;

                left++;
                right--;
            }
        }
    }
}
/*Direct rotate karna mushkil lagta hai.
Step 1: Transpose
Rows ko columns me convert karo. matrix[i][j] ↔ matrix[j][i]

Step 2: Har row reverse karo 
  int left = 0;
  int right = n - 1;

    while (left < right) {

    int temp = matrix[i][left];
    matrix[i][left] = matrix[i][right];
    matrix[i][right] = temp;
 */