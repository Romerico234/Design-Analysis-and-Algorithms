import java.util.ArrayList;

public class Q5DPApproach {
    public static void main(String[] args) {
        int[][] grid = {
                { 5, 4, 10, 8, 9 },
                { 7, 11, 9, 20, 7 },
                { 40, 13, 11, 6, 12 },
                { 16, 27, 100, 20, 10 }
        };

        ArrayList<Integer> path = findMaxCoinsDP(grid);
        System.out.println("Path: " + path);
    }

    public static ArrayList<Integer> findMaxCoinsDP(int[][] grid) {
        int N = grid.length;
        int M = grid[0].length;

        int[][] dp = new int[N][M];
        int[][] pathTable = new int[N][M];

        for (int col = 0; col < M; col++) {
            dp[0][col] = grid[0][col];
            pathTable[0][col] = -1;
        }

        for (int row = 1; row < N; row++) {
            for (int col = 0; col < M; col++) {
                int maxFromAbove = dp[row - 1][col];
                int fromCol = col;

                if (col > 0 && dp[row - 1][col - 1] > maxFromAbove) {
                    maxFromAbove = dp[row - 1][col - 1];
                    fromCol = col - 1;
                }

                if (col < M - 1 && dp[row - 1][col + 1] > maxFromAbove) {
                    maxFromAbove = dp[row - 1][col + 1];
                    fromCol = col + 1;
                }

                dp[row][col] = grid[row][col] + maxFromAbove;
                pathTable[row][col] = fromCol;
            }
        }

        int lastCol = 0;
        for (int col = 0; col < M; col++) {
            if (dp[N - 1][col] > dp[N - 1][lastCol]) lastCol = col;
        }

        ArrayList<Integer> path = new ArrayList<>();
        int currentCol = lastCol;
        for (int row = N - 1; row >= 0; row--) {
            path.add(0, grid[row][currentCol]);
            if (row > 0) currentCol = pathTable[row][currentCol];
        }

        return path;
    }
}
