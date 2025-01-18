package MMN13;

/**
 * @author Shira Hachmon 
 */

public class SpecialArr {
    
    /** 
     * All elements in odd indexes must be smaller than their two neighbors.
     * All members in even indexes must be greater than their two neighbors.
     * median value is already none for us, so we have an array un sorted that contains different values, and a median. 
     */

    public static int[] specialArr(int[] arr, int median){
        int length=arr.length;

        // Iterate through arr and adjust values based on even and odd indexes
        for (int i = 0; i < length; i++) {
            
            if (i % 2 == 0) { // even indexes
                if (i > 0 && arr[i] <= arr[i - 1]) {
                    // Swap with the previous element if not greater than it
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                }
                if (i < length - 1 && arr[i] <= arr[i + 1]) {
                    // Swap with the next element if not greater than it
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }else{ // odd indexes
                if (i > 0 && arr[i] >= arr[i - 1]) {
                    // Swap with the previous element if not smaller than it
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                }
                if (i < length - 1 && arr[i] >= arr[i + 1]) {
                    // Swap with the next element if not smaller than it
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }

            // Median-related condition: Ensuring odd and even index conditions around the median
            if (arr[i] < median && i % 2 == 0) {
                // If the element is smaller than the median and at an even index,
                // swap it with a larger neighbor (this enforces it to be greater than neighbors)
                if (i < length - 1 && arr[i] <= arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            if (arr[i] > median && i % 2 != 0) {
                // If the element is greater than the median and at an odd index,
                // swap it with a smaller neighbor (this enforces it to be smaller than neighbors)
                if (i > 0 && arr[i] >= arr[i - 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                }
            }
        }

        return arr;
    } 
}