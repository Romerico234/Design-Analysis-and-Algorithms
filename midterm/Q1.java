public class Q1 {
    public static void main(String[] args) {
        int[] arr = { -1,3,1,5,7,3,6,4,-1,9 };
        int res1 = getMaxKCenter(arr, 2);
        int res2 = getMaxKCenter(arr, 4);

        System.out.println("Result 1: " + "Index is " + res1 + " and element is " + arr[res1]);
        System.out.println("Result 2: " + "Index is " + res2 + " and element is " + arr[res2]);
    }

    public static int getMaxKCenter(int[] arr, int k) {
        if (arr.length == 0) return -1;  
    if (arr.length < 2 * k + 1) return -1;  

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
