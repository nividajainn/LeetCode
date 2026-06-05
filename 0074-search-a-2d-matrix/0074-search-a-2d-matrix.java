class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;  
        int high = n*m-1;  
        // Matrix ko 1D array maan rahe hain
        // Total elements = n * m

        while(low <= high){
            int mid = (low + high)/2;
            
            // 1D index ko 2D matrix ke row aur column me convert karo
            int row = mid / n;
            int col = mid % n;

            if(matrix[row][col] == target) return true;

            else if(matrix[row][col] < target)
            low = mid+1;

            else
            high = mid-1;
        }
        return false;
    }
}

/* Brute force TC: O(m*n)

int m = matrix.length;
int n = matrix[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j] == target){
                    return true;
                }
            }
        }
        return false; */