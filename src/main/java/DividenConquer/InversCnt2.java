package DividenConquer;

public class InversCnt2 {

    // Merging two sorted halves and counting cross inversions
    public static int merge(int arr[], int left, int mid, int right) {
        int i = left;  // Pointer for the left half
        int j = mid;   // Pointer for the right half
        int k = 0;     // Pointer for the temp array
        int invCount = 0;  // To keep track of the number of inversions
        int temp[] = new int[(right - left + 1)];  // Temporary array to store the merged result

        // Merge the two halves while counting inversions
        while ((i < mid) && (j <= right)) {
            if (arr[i] <= arr[j]) {
                // No inversion if the element in the left half is smaller or equal
                temp[k] = arr[i];
                i++;
            } else {
                // Inversion found: element in the right half is smaller
                temp[k] = arr[j];
                // Since arr[i] > arr[j], all elements from arr[i] to arr[mid-1] are greater than arr[j]
                invCount += (mid - i);  // Count inversions
                j++;
            }
            k++;  // Move to the next position in temp
        }

        // Copy remaining elements of the left half (if any)
        while (i < mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }

        // Copy remaining elements of the right half (if any)
        while (j <= right) {
            temp[k] = arr[j];
            j++;
            k++;
        }

        // Copy the merged subarray back to the original array
        for (i = left, k = 0; i <= right; i++, k++) {
            arr[i] = temp[k];
        }

        return invCount;  // Return the number of inversions found during the merge
    }

    // Recursive function to divide the array into halves and count inversions
    public static int mergeSort(int arr[], int left, int right) {
        int invCount = 0;

        if (right > left) {
            // Find the middle point of the current subarray
            int mid = (right + left) / 2;

            // Recursively count inversions in the left half
            invCount += mergeSort(arr, left, mid);
            // Recursively count inversions in the right half
            invCount += mergeSort(arr, mid + 1, right);

            // Count the cross inversions (inversions between the two halves) and merge them
            invCount += merge(arr, left, mid + 1, right);
        }
        return invCount;  // Return the total inversion count
    }

    // Function to initialize the merge sort process
    public static int getInversions(int arr[]) {
        int n = arr.length;
        return mergeSort(arr, 0, n - 1);  // Call mergeSort on the entire array
    }

    // Main function to test the inversion counting algorithm
    public static void main(String args[]) {
        int arr[] = {1, 20, 6, 4, 5};  // Example array
        System.out.println("Inversions = " + getInversions(arr));  // Print the number of inversions
    }
}
