public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // Target element not found
    }

    public static void main(String[] args) {
        int[] sortedArray = { 1, 2, 5, 5, 7, 9, 11, 11, 13, 15, 15, 17, 19, 20, 25 };
        int target = 7;

        int index = binarySearch(sortedArray, target);

        if (index != -1) {
            System.out.println("Target element found at index: " + index);
        } else {
            System.out.println("Target element not found in the array.");
        }
    }
}
