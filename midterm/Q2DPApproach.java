import java.util.ArrayList;

public class Q2DPApproach {

    public static void main(String[] args) {
        int[] W = { 2, 5, 8, 13, 17 };
        int[] S = { 3, 2, 2, 1, 1 };
        int C = 30;

        ArrayList<Integer> result = dpKnapsack(W, S, C);
        if (result.isEmpty()) {
            System.out.println("No solution");
        } else {
            System.out.println("Minimum number of weights: " + result.size());
            System.out.println("Combination: " + result);
        }
    }

    public static ArrayList<Integer> dpKnapsack(int[] W, int[] S, int C) {
        int[] dp = new int[C + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        ArrayList<Integer>[] combination = (ArrayList<Integer>[]) new ArrayList[C + 1];
        for (int i = 0; i <= C; i++) {
            combination[i] = new ArrayList<>(); 
        }

        for (int i = 0; i < W.length; i++) { 
            for (int j = C; j >= 0; j--) { 
                for (int k = 1; k <= S[i]; k++) { 
                    if (j >= k * W[i] && dp[j - k * W[i]] != Integer.MAX_VALUE) { 
                        if (dp[j] > dp[j - k * W[i]] + k) { 
                            dp[j] = dp[j - k * W[i]] + k;

                            combination[j] = new ArrayList<>(combination[j - k * W[i]]);
                            for (int count = 0; count < k; count++) {
                                combination[j].add(W[i]);
                            }
                        }
                    }
                }
            }
        }

        return dp[C] == Integer.MAX_VALUE ? new ArrayList<>() : combination[C];
    }
}
