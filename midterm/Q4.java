import java.util.LinkedHashSet;

public class Q4 {
    public static void main(String[] args) {
        double[] arr = { 3.1, -2.7, 5.6, 3.1, 6.2, -2.7, -2.7, 3.1, 6.2 };
        double[] result = removeDuplicatesOptimalApproach(arr);
        for (double val : result) {
            System.out.print(val + " ");
        }

    }

    public static double[] removeDuplicatesBruteForce(double arr[]) {
        if (arr.length == 0) return new double[0];

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

            if (!isDuplicate) temp[size++] = arr[i];
            
        }

        double[] result = new double[size];
        for (int i = 0; i < size; i++) result[i] = temp[i];

        return result;
    }

    public static double[] removeDuplicatesOptimalApproach(double arr[]) {
        if (arr.length == 0) return new double[0];
        
        LinkedHashSet<Double> temp = new LinkedHashSet<Double>();
        for (int i = 0; i < arr.length; i++) temp.add(arr[i]);

        double[] result = new double[temp.size()];
        int idx = 0;
        for (double val : temp) result[idx++] = val;

        return result;
    }
}
