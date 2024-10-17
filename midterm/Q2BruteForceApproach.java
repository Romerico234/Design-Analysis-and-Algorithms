import java.util.ArrayList;

public class Q2BruteForceApproach {
    public static void main(String[] args) {
        int[] W = { 2, 5, 8, 13, 17 };
        int[] S = { 3, 2, 2, 1, 1 };
        int C = 30;

        ArrayList<Integer> result = bruteForceKnapsack(W, S, C);
        System.out.println("Best combination: " + result);
    }

    public static ArrayList<Integer> bruteForceKnapsack(int[] W, int[] S, int C) {
        ArrayList<Integer> bestCombo = new ArrayList<>();
        int[] minWeights = { Integer.MAX_VALUE };

        bruteForce(new ArrayList<>(), 0, 0, W, S, C, bestCombo, minWeights);

        return bestCombo;
    }

    private static void bruteForce(ArrayList<Integer> currentCombo, int currentSum, int idx, int[] W, int[] S, int C, ArrayList<Integer> bestCombo, int[] minWeights) {
        if (currentSum > C) return;
        if (currentSum == C) {
            if (currentCombo.size() < minWeights[0]) {
                minWeights[0] = currentCombo.size();
                bestCombo.clear();
                bestCombo.addAll(currentCombo);
            }
            return;
        }

        if (idx == W.length) return;

        for (int count = 0; count <= S[idx]; count++) {
            ArrayList<Integer> newCombo = new ArrayList<>(currentCombo);
            for (int i = 0; i < count; i++) newCombo.add(idx);
            bruteForce(newCombo, currentSum + W[idx] * count, idx + 1, W, S, C, bestCombo, minWeights);
        }
    }
}
