class Solution {

    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int[][] memo;

    public int longestIncreasingPath(int[][] matrix) {

        int  rows = matrix.length;
        int cols = matrix[0].length;
        memo = new int[rows][cols];

        int max = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                max  = Math.max(max, dfs(matrix, i, j));
            }
        }

        return max;
    }

    int dfs (int[][] matrix, int r, int c) {

        if (memo[r][c] != 0) return memo[r][c];

        int rows = matrix.length;
        int cols = matrix[0].length;

        int best = 1;


        for(int[] d : directions) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
                continue;
            }
            if (matrix[nr][nc] > matrix[r][c]) {
                best = Math.max(best, 1 + dfs(matrix, nr, nc));
            }
        }

        return memo[r][c] = best;
    }
}