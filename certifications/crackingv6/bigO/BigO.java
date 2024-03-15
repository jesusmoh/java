package bigO;

public class BigO {

    // Constant Time (O(1)):
    // Algorithms that have a fixed number of operations regardless of the input
    // size.
    // Directly accessing an element in an array or performing a single operation on
    // a variable.
    // Linear Time (O(n)):
    // Algorithms that iterate through a collection once.
    // Loops that depend on the size of the input data.
    // Quadratic Time (O(n^2)):
    // Nested loops where each loop iterates over the entire input data.
    // Operations that involve comparing every element with every other element.
    // Logarithmic Time (O(log n)):
    // Algorithms that divide the problem in half at each step.
    // Binary search algorithms or divide-and-conquer strategies.
    // Linearithmic Time (O(n log n)):
    // Sorting algorithms like merge sort or quicksort that have a linearithmic
    // complexity.
    // Combining linear and logarithmic operations.

    public static void main(String[] args) {

        var numbers = new int[] { 1, 2, 3, 4, 5 };
        constantTimeExample(numbers);
        linearTimeExample(numbers);
        binarySearch(numbers, 3);
    }

    static int constantTimeExample(int[] arr) {
        System.out.println("O(1)");
        return arr[0];
    }

    static void linearTimeExample(int[] arr) {
        for (int num : arr) {
            // doing x
        }
        System.out.println("O(n)");
    }

    static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("O(log n)");
        return -1;
    }

    static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;

            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);

            merge(arr, low, mid, high);
        }
        System.out.println("n log n");
    }

    static void merge(int[] arr, int low, int mid, int high) {
        // Merge two sorted subarrays
    }

}