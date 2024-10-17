import java.util.ArrayList;

public class Q2DPApproach {

    public static void main(String[] args) {
        int[] W = { 2, 5, 8, 13, 17 };
        int[] S = { 3, 2, 2, 1, 1 };
        int C = 30;

        ArrayList<Integer> result = dpKnapsack(W, S, C);
        if (result.isEmpty()) System.out.println("No solution");
        else System.out.println("Combination: " + result);
    }

    public static ArrayList<Integer> dpKnapsack(int[] W, int[] S, int C) {
        int[] dp = new int[C + 1];
        for (int i = 1; i < dp.length; i++) dp[i] = Integer.MAX_VALUE;

        ArrayList<Integer>[] combo = (ArrayList<Integer>[]) new ArrayList[C + 1];
        for (int i = 0; i <= C; i++) combo[i] = new ArrayList<>(); 

        for (int i = 0; i < W.length; i++) { 
            for (int j = C; j >= 0; j--) { 
                for (int k = 1; k <= S[i]; k++) { 
                    if (j >= k * W[i] && dp[j - k * W[i]] != Integer.MAX_VALUE) { 
                        if (dp[j] > dp[j - k * W[i]] + k) { 
                            dp[j] = dp[j - k * W[i]] + k;

                            combo[j] = new ArrayList<>(combo[j - k * W[i]]);
                            for (int count = 0; count < k; count++) combo[j].add(i);
                        }
                    }
                }
            }
        }

        return dp[C] == Integer.MAX_VALUE ? new ArrayList<>() : combo[C];
    }
}
