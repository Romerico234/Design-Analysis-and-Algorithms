import java.util.ArrayList;

public class Q2BruteForceApproach {
    public static void main(String[] args) {
        int[] W = { 2, 5, 8, 13, 17 };
        int[] S = { 3, 2, 2, 1, 1 };
        int C = 30;

        ArrayList<Integer> result = bruteForceKnapsack(W, S, C);
        System.out.println("Best combination: " + result);
        System.out.println("Minimum number of weights: " + result.size());
    }

    public static ArrayList<Integer> bruteForceKnapsack(int[] W, int[] S, int C) {
        ArrayList<Integer> bestCombination = new ArrayList<>();
        int[] minWeights = { Integer.MAX_VALUE };

        bruteForce(new ArrayList<>(), 0, 0, W, S, C, bestCombination, minWeights);

        return bestCombination;
    }

    private static void bruteForce(ArrayList<Integer> currentCombination, int currentSum, int idx, int[] W, int[] S, int C,
                                   ArrayList<Integer> bestCombination, int[] minWeights) {
        if (currentSum > C) return;

        if (currentSum == C) {
            if (currentCombination.size() < minWeights[0]) {
                minWeights[0] = currentCombination.size();
                bestCombination.clear();
                bestCombination.addAll(currentCombination);
            }
            return;
        }

        if (idx == W.length) {
            return;
        }

        for (int count = 0; count <= S[idx]; count++) {
            ArrayList<Integer> newCombination = new ArrayList<>(currentCombination);
            for (int i = 0; i < count; i++) {
                newCombination.add(W[idx]);
            }
            bruteForce(newCombination, currentSum + W[idx] * count, idx + 1, W, S, C, bestCombination, minWeights);
        }
    }
}
