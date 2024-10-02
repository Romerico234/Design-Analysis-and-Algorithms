public class Quiz2 {

    // Main Divide and Conquer method
    public static int max3Summation(int[] A, int l, int r) {
        // Base case: if the subarray is too small to contain any valid 3-summations
        if (r - l < 6) {
            return findMaxInSmallArray(A, l, r);
        }

        // Divide the array into two halves
        int mid = (l + r) / 2;

        // Conquer: find maximum 3-summation in the left and right halves
        int lMax = max3Summation(A, l, mid);
        int rMax = max3Summation(A, mid + 1, r);

        // Combine: find the maximum 3-summation that spans the boundary
        int crossMax = findCrossMax(A, l, mid, r);

        // Return the maximum result
        return Math.max(lMax, Math.max(rMax, crossMax));
    }

    // Method to handle base case: find the maximum 3-summation in a small subarray
    private static int findMaxInSmallArray(int[] A, int l, int r) {
        int maxSum = Integer.MIN_VALUE;
        
        // Only check for 3-summations if the subarray has at least 7 elements
        for (int t = l + 3; t <= r - 3; t++) {
            int a = A[t - 3];
            int c = A[t + 3];
            int sum3 = a + c;

            if (sum3 > maxSum) {
                maxSum = sum3;
            }
        }

        return maxSum;
    }

    // Method to find the maximum 3-summation across the boundary
    private static int findCrossMax(int[] A, int left, int mid, int right) {
        int maxSum = Integer.MIN_VALUE;

        // Check for t in the range close to the boundary (mid), i.e., mid-2 to mid+2
        for (int t = mid - 2; t <= mid + 2; t++) {
            if (t - 3 >= left && t + 3 <= right) {
                int a = A[t - 3];
                int c = A[t + 3];
                int sum3 = a + c;

                if (sum3 > maxSum) {
                    maxSum = sum3;
                }
            }
        }

        return maxSum;
    }

    // Wrapper function to start the divide and conquer process
    public static int findMax3Summation(int[] A) {
        return max3Summation(A, 0, A.length - 1);
    }

    public static void main(String[] args) {
        // Example array
        int[] A = {5, 5, 8, -1, 6, 7, 4, 1, 9, 0, 10, 2};
        int result = findMax3Summation(A);
        System.out.println("Maximum 3-summation integer: " + result);
    }
}
