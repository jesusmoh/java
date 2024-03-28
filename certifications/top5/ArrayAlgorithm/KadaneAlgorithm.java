
public class KadaneAlgorithm {

    // Given an array of integers, find the maximum sum contiguous subarray
    // (Kadane's Algorithm).

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4 };
        System.out.println("Maximum contiguous sum is " + maxSubArraySum(a));
    }

    // (Kadane's Algorithm)
    public static int maxSubArraySum(int[] arr) {
        int accu = 0;
        int max_to_return = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            accu = arr[i] + accu;
            if (accu > max_to_return) {
                max_to_return = accu;
            }
            if (accu < 0)// if it is + , then it acumaltes
                accu = 0;
        }
        return max_to_return;
    }

}
