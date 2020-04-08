public class BinarySearch {
    static int binarySearch(int[] list, int value) {
        int low = 0;
        int high = list.length - 1;
        while (high >= low) {
            int mid = (low + high) / 2;
            if (value == list[mid]) {
                return mid;
            } else if (value < list[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    static int binarySearchRecursive(int[] list, int value) {
        int left = 0;
        int right = list.length - 1;
        return binarySearchRecursive(list, left, right, value);
    }

    private static int binarySearchRecursive(int[] list, int left, int right, int value) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (value == list[mid]) {
            return mid;
        } else if (value < list[mid]) {
            return binarySearchRecursive(list, left, mid - 1, value);
        } else {
            return binarySearchRecursive(list, mid + 1, right, value);
        }
    }
}
