import java.util.LinkedHashSet;

public class Q4 {
    public static void main(String[] args) {
        double[] arr = { 3.1, -2.7, 5.6, 3.1, 6.2, -2.7, -2.7, 3.1, 6.2 };
        double[] result = optimalRemoveDuplicates(arr);
        for (double val : result) {
            System.out.print(val + " ");
        }

    }

    /**
     * Given an array 𝐴[] of 𝑛 elements possibly with duplicates. Design a
     * procedure to remove the duplicates (and
     * retain only the first occurrences in their order) of elements in 𝐴[] without
     * sorting.
     * Sample: Input 𝐴 = [3.1,−2.7,5.6,3.1,6.2,−2.7,−2.7,3.1,6.2]. Output:
     * [3.1,−2.7,5.6,6.2].
     */
    public static double[] bruteRemoveDuplicates(double arr[]) {
        double[] temp = new double[arr.length];
        int size = 0;

        for (int i = 0; i < arr.length; i++) {
            boolean isDuplicate = false;
            for (int j = 0; j < size; j++) {
                if (arr[i] == temp[j]) {
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                temp[size++] = arr[i];
            }
        }

        double[] result = new double[size];
        for (int i = 0; i < size; i++) {
            result[i] = temp[i];
        }

        return result;
    }

    public static double[] optimalRemoveDuplicates(double arr[]) {
        LinkedHashSet<Double> temp = new LinkedHashSet<Double>();
        for (int i = 0; i < arr.length; i++) {
            temp.add(arr[i]);
        }
        double[] result = new double[temp.size()];

        int i = 0;
        for (double val : temp) {
            result[i++] = val;
        }

        return result;
    }
}
