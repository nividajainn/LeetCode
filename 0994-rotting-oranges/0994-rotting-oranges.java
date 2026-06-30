class Solution {

    public int orangesRotting(int[][] grid) {

        // Queue stores the position (row, col) of rotten oranges
        Queue<int[]> q = new LinkedList<>();

        int fresh = 0;   // Count of fresh oranges
        int time = 0;    // Minutes required

        int rows = grid.length;
        int cols = grid[0].length;

        // Traverse the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                // Add all initially rotten oranges to the queue
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }

                // Count fresh oranges
                else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        // Directions: Up, Down, Left, Right
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        // Run BFS until no rotten oranges are left to process
        // or all fresh oranges become rotten
        while (!q.isEmpty() && fresh > 0) {

            // Number of rotten oranges in the current minute
            int size = q.size();

            // One BFS level = One minute
            time++;

            // Process all rotten oranges of the current minute
            for (int i = 0; i < size; i++) {

                int[] curr = q.poll();

                int r = curr[0];
                int c = curr[1];

                // Check all four directions
                for (int k = 0; k < 4; k++) {

                    int nr = r + dr[k];
                    int nc = c + dc[k];

                    // If neighbour is inside the grid and is fresh
                    if (nr >= 0 && nr < rows &&
                        nc >= 0 && nc < cols &&
                        grid[nr][nc] == 1) {

                        // Make it rotten
                        grid[nr][nc] = 2;

                        // One fresh orange becomes rotten
                        fresh--;

                        // Add newly rotten orange for the next minute
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
        }

        // If all oranges became rotten, return time
        // Otherwise some fresh oranges could never be reached
        return fresh == 0 ? time : -1;
    }
}