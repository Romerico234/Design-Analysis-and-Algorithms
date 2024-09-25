import java.util.*;

/**
 * Problem:
 * + Input: An array A containing non-zero integers.
 * + Output: Two indices s and t such that 𝐴[𝑠] + 𝐴[𝑠 + 1] + 𝐴[𝑠 + 2] + ⋯
 * + 𝐴[𝑡] is maximized.
 * Answer the following questions.
 * 1. Your brute force approach (3 – 6 steps)
 * 2. Write pseudo-code for your approach to solve the problem
 * 3. Is your approach correct?
 * 4. Time and space complexity of your answer.
 */

public class Quiz1 {
    public static void main(String[] args) {
        int[] arr = { -45, 1, 0, 6, 59, 3, -28, 100, -12, -77 };
        List<int[]> results = findMaxBetweenTwoIndices(arr);
        System.out.println("Maximum sum subarrays with their indices:");
        for (int[] result : results) System.out.println("From " + result[0] + " to " + result[1] + " with max sum: " + sum(arr, result[0], result[1]));
    }

    /**
     * Steps:
     * 1. Define and intialize helper variables, int max, s, t
     * 2. The outer loop iterates through the array with a starting index start from 0 to the end of the array.
     * 3. The inner Loop loop starts at start and iterates to the end of the array
     * 4. Then I calculate the sum of the subarry within the inner loop by using another loop to calculate the sum of elements between start and end
     * 5. Update maxSum if currSum is greater than maxSum and set s and t to the current indices start and end
     * The time complexity is O(n^3) due to the three for-loops
     */
    public static List<int[]> findMaxBetweenTwoIndices(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        List<int[]> maxSubarrays = new ArrayList<>();

        for (int start = 0; start < arr.length; start++) {
            for (int end = start; end < arr.length; end++) {
                int currSum = 0;

                for (int i = start; i <= end; i++) currSum += arr[i];

                if (currSum > maxSum) {
                    maxSum = currSum;
                    maxSubarrays.clear();
                    maxSubarrays.add(new int[] { start, end });
                } else if (currSum == maxSum) {
                    maxSubarrays.add(new int[] { start, end });
                }
            }
        }

        return maxSubarrays;
    }

    public static int sum(int[] arr, int start, int end) { return arr[start] + arr[end]; }

}
