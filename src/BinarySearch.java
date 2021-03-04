/**
 * @author Pavel Peskov
 */
public class BinarySearch {

    public static void main(String[] args) {

        int[] sortedArray = new int[] {-1, 3, 5, 8, 10, 15, 16, 20};
        final int KEY = 8;

        System.out.println(
                "Ordinary way: " +
                binarySearch(new int[] {-1, 3, 5, 8, 10, 15, 16, 20}, KEY)
        );

        System.out.println(
                "Recursive way: " +
                binarySearchRecursive(sortedArray, KEY, 0, sortedArray.length - 1)
        );
    }

    public static int binarySearch(int[] a, int key) {
        // O(log N)
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (key < a[mid]) {
                high = mid - 1;
            } else if (key > a[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int binarySearchRecursive(int[] sortedArray, int key, int low, int high) {

        int mid = low + (high - low) / 2;

        if ( sortedArray[mid] == key ) {
            return mid;
        }

        // base case
        if (low > high) return -1;

        return (key < sortedArray[mid])
                ? binarySearchRecursive(sortedArray, key, low, mid - 1)
                : binarySearchRecursive(sortedArray, key, mid + 1, high);
    }

}
