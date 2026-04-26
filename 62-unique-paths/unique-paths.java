class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for (int i[] : dp) {
            Arrays.fill(i, -1);
        }
        return solve(dp, m - 1, n - 1);
    }

    public int solve(int dp[][], int m, int n) {
        if (m == 0 && n == 0) return 1;
        if (m < 0 || n < 0) return 0;
        if (dp[m][n] != -1) return dp[m][n];

        int up = solve(dp, m - 1, n);
        int left = solve(dp, m, n - 1);
        
        return dp[m][n] = up + left;
    }
}