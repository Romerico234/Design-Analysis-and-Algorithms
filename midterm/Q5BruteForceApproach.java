import java.util.ArrayList;

public class Q5BruteForceApproach {
    public static void main(String[] args) {
        int[][] grid = {
            { 5, 4, 10, 8, 9 },
            { 7, 11, 9, 20, 7 },
            { 40, 13, 11, 6, 12 },
            { 16, 27, 100, 20, 10 }
        };

        ArrayList<Integer> path = findMaxCoinsBruteForce(grid);
        System.out.println("Path: " + path);
    }

    public static ArrayList<Integer> findMaxCoinsBruteForce(int[][] grid) {
        int N = grid.length, M = grid[0].length, maxCoins = 0;
        ArrayList<Integer> maxPath = new ArrayList<>();

        for (int col = 0; col < M; col++) {
            ArrayList<Integer> path = new ArrayList<>();
            int resultCoins = maxCoinsBruteForce(grid, 0, col, N, M, path);
            if (resultCoins > maxCoins) {
                maxCoins = resultCoins;
                maxPath = path;
            }
        }

        return maxPath;
    }

    public static int maxCoinsBruteForce(int[][] grid, int row, int col, int N, int M, ArrayList<Integer> path) {
        if (row == N) return 0;

        int currentCoins = grid[row][col], maxCoins = 0;
        ArrayList<Integer> bestPath = new ArrayList<>();

        int downCoins = maxCoinsBruteForce(grid, row + 1, col, N, M, bestPath);
        if (downCoins > maxCoins) {
            maxCoins = downCoins;
            path.clear();
            path.addAll(bestPath);
        }

        if (col - 1 >= 0) {
            ArrayList<Integer> downLeftPath = new ArrayList<>();
            int downLeftCoins = maxCoinsBruteForce(grid, row + 1, col - 1, N, M, downLeftPath);
            if (downLeftCoins > maxCoins) {
                maxCoins = downLeftCoins;
                path.clear();
                path.addAll(downLeftPath);
            }
        }

        if (col + 1 < M) {
            ArrayList<Integer> downRightPath = new ArrayList<>();
            int downRightCoins = maxCoinsBruteForce(grid, row + 1, col + 1, N, M, downRightPath);
            if (downRightCoins > maxCoins) {
                maxCoins = downRightCoins;
                path.clear();
                path.addAll(downRightPath);
            }
        }

        path.add(0, currentCoins);
        return currentCoins + maxCoins;
    }
}
