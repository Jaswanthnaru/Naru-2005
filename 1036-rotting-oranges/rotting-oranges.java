class Solution {
    // Overall Space Complexity - O(N*M)=> for Queue
    // Overall Time Complexity - O(N*M) + 4*O(N*M)
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int freshOranges = 0;

        // Space - O(N*M)
        Queue<int[]> q = new LinkedList<>();

        // Time - O(N*M)
        // for multiple rotten oranges
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    freshOranges++;
                } else if (grid[i][j] == 2) {
                    q.offer(new int[] { i, j, 0 });
                }
            }
        }

        int minLevel = 0;

        // directions={top, right, bottom, left}
        int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

        // Time - 4*O(N*M) => for each vertex take 4 dir fresh oranges
        while (!q.isEmpty()) {
            int i = q.peek()[0];
            int j = q.peek()[1];
            int level = q.peek()[2];
            q.poll();

            minLevel = level;

            // // top
            // if (i > 0 && grid[i - 1][j] == 1) {
            //     q.offer(new int[] { i - 1, j, level + 1 });
            //     grid[i - 1][j] = 2;
            // }

            // // right
            // if (j < grid[0].length - 1 && grid[i][j + 1] == 1) {
            //     q.offer(new int[] { i, j + 1, level + 1 });
            //     grid[i][j + 1] = 2;
            // }

            // // bottom
            // if (i < grid.length - 1 && grid[i + 1][j] == 1) {
            //     q.offer(new int[] { i + 1, j, level + 1 });
            //     grid[i + 1][j] = 2;
            // }

            // // left
            // if (j > 0 && grid[i][j - 1] == 1) {
            //     q.offer(new int[] { i, j - 1, level + 1 });
            //     grid[i][j - 1] = 2;
            // }

            for (int[] dir : dirs) {
                int nrow = i + dir[0];
                int ncol = j + dir[1];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1) {
                    q.offer(new int[] { nrow, ncol, level + 1 });
                    grid[nrow][ncol] = 2;
                    freshOranges--;
                }
            }
        }

        // if no fresh oranges return minLevel 
        return freshOranges == 0 ? minLevel : -1;
    }
}