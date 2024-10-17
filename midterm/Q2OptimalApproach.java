import java.util.Arrays;

public class Q2OptimalApproach {
    public static void main(String[] args) {
        int W[] = { 2, 5, 8, 13, 17 }; 
        int S[] = { 3, 2, 2, 1, 1 };   
        int C = 30; 

        int N = W.length; 

        int[] result = knapSack(C, W, S, N);

        if (result.length == 0) {
            System.out.println("No combination found.");
        } else {
            System.out.print("Indices of weights used: ");
            for (int idx : result) {
                System.out.print(idx + " ");
            }
        }
    }

    /**
     * Assume that, in Knapsack problem, each weight 𝑊[𝑖] can be selected up to a certain 𝑆[𝑖] times, e.g., if 𝑊 =
     * [2,5,8,13,17] and 𝑆=[3,2,2,1,1] it means weight 𝑊[1]=2 can be selected up to 𝑆[1]=3 times, weight 
     * 𝑊[2]=5 can be selected up to 𝑆[2]=2 times, etc. Given a capacity 𝐶, find the least number of weights that add 
     * up closest (or equal) to 𝐶. For instance, with 𝐶 =30 two possible combinations are [13,17] and [2,2,5,5,8,8]. 
     * [13,17] is the answer with the least number of weights needed.
     */

    public static int[] knapSack(int C, int[] W, int[] S, int N) {
        int dp[][] = new int[N + 1][C + 1];
        int[][] dpCount = new int[N + 1][C + 1]; 
        
        int[][][] dpIndices = new int[N + 1][C + 1][C + 1];  

        for (int i = 0; i < N + 1; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE); 
        }
        dp[0][0] = 0; 

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= C; j++) {
                dp[i][j] = dp[i - 1][j];  
                dpCount[i][j] = dpCount[i - 1][j]; 
                dpIndices[i][j] = Arrays.copyOf(dpIndices[i - 1][j], dpIndices[i - 1][j].length);  
                
                for (int k = 1; k <= S[i - 1] && j >= k * W[i - 1]; k++) {
                    int prevCap = j - k * W[i - 1];
                    if (dp[i - 1][prevCap] != Integer.MAX_VALUE) {
                        int newWeightCount = dp[i - 1][prevCap] + k;
                        if (newWeightCount < dp[i][j]) {
                            dp[i][j] = newWeightCount;
                            dpCount[i][j] = dpCount[i - 1][prevCap] + k;
                            dpIndices[i][j] = Arrays.copyOf(dpIndices[i - 1][prevCap], C + 1);
                            for (int x = 0; x < k; x++) {
                                dpIndices[i][j][dpCount[i - 1][prevCap] + x] = i - 1;
                            }
                        }
                    }
                }
            }
        }

        if (dp[N][C] == Integer.MAX_VALUE) {
            return new int[0];  // No solution found
        }
        
        // Retrieve the indices from dpIndices
        int count = dpCount[N][C];
        return Arrays.copyOf(dpIndices[N][C], count);
    }
}
