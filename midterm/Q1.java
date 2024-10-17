public class Q1 {
    public static void main(String[] args) {
        int[] arr = { -1,3,1,5,7,3,6,4,-1,9 };
        int res1 = getMaxKCenter(arr, 2);
        int res2 = getMaxKCenter(arr, 4);

        System.out.println("Result 1: " + "Index is " + res1 + " and element is " + arr[res1]);
        System.out.println("Result 2: " + "Index is " + res2 + " and element is " + arr[res2]);
    }
    /**
     * A position in an array is said to be a 𝑘-center if the two values 𝑘 hops away from it (towards the front and back of 
     * the array) are the same. For instance, with 𝐴 = [−1,3,1,5,7,3,6,4,−1,9] position #4 (value 5) is a 2-center, and 
     * position #5 (value 7) is a 4-center. Given an array A of n integers, find the position with the maximal 𝑘-center 
     * (i.e., the center with maximal radius 𝑘) by at least two approaches.  
     */
    public static int getMaxKCenter(int[] arr, int k) {
        int[] temp = new int[arr.length]; 
        for (int i = k, j = 0; i < arr.length - k - 1; i++) {
            int minusKHop = arr[i - k];
            int plusKHop = arr[i + k];

            if (minusKHop == plusKHop) temp[j++] = i;
        }

        int max = temp[0];
        int maxIdx = 0;
        for (int i = 1; i < temp.length; i++) {
            if (arr[temp[i]] > max) {
                max = arr[temp[i]];
                maxIdx = i;
            }
        }

        return temp[maxIdx];
    }
}
