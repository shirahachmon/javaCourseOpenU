
/**
 * @author Shira Hachmon 
 */

public class Ex13{

    /** _____________________________________________________________________________________________________________________________________ */

    /** first exercise
     * All elements in odd indexes must be smaller than their two neighbors.
     * All members in even indexes must be greater than their two neighbors.
     * median value is already none for us, so we have an array un sorted that contains different values, and a median. 
     */
     public static int[] specialArr(int[] arr, int median){
	    int length= arr.length;

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





    /** _____________________________________________________________________________________________________________________________________ */


    /** second exercise
     * This function finds the smallest missing positive integer from an unsorted array of integers. 
     * */
    public static int first (int[] arr){

        // Placing positive numbers in the right order. 
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] > 0 && arr[i] <= arr.length && arr[arr[i] - 1] != arr[i]){
                // Swap between those values. 
                int temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
            }
        }
    
        // Searching for the smaller first value that does not found in the array. 
        for (int i = 0; i < arr.length; i++)  if (arr[i] != i + 1) return i + 1;
    
        // Edge case- if all positive numbers are there, then the smaller first number will be the last one plus 1. 
        return arr.length + 1;
    }  






    /** _____________________________________________________________________________________________________________________________________ */

    // third exercise- Main function. 
    public static int longestNearlyPal(int[] arr) {
        return longestNearlyPal(arr, 0, arr.length - 1, false);
    }

    /**
     * Recursive function to find the length of the longest nearly-palindromic subarray.
     */
    private static int longestNearlyPal(int[] arr, int left, int right, boolean removed) {

        // Base cases: If the subarray is invalid, return 0
        if (left > right) return 0;
        // A single element is always a palindrome
        if (left == right) return 1; 

        // If the current subarray is a palindrome, return its length
        if (isPalindrome(arr, left, right)) return right - left + 1;

        // If we have already removed one element, we should not remove another one
        if (removed)  return 0;

        // Try removing the left element and check the remaining subarray
        int removeLeft = longestNearlyPal(arr, left + 1, right, true);

        // Try removing the right element and check the remaining subarray
        int removeRight = longestNearlyPal(arr, left, right - 1, true);

        // Return the maximum length between the two options
        return Math.max(removeLeft, removeRight);
    }

    /**
     * Helper function to check if a subarray is a palindrome.
     */
    private static boolean isPalindrome(int[] arr, int left, int right) {
        // Base case: If the pointers cross or meet, the subarray is a palindrome
        if (left >= right) return true;

        // If the elements at the current pointers are not equal, it's not a palindrome
        if (arr[left] != arr[right]) return false;

        // Checking the inner subarray
        return isPalindrome(arr, left + 1, right - 1);
    }




    /** _____________________________________________________________________________________________________________________________________ */

    /** Main function of exercise 4.  */
    public static int extreme(int[][] mat) {
        // Start the recursion- initial parameters
        return extreme(mat, 0, 0, mat[0][0], new boolean[mat.length][mat.length]);
    }

    // Overloaded extreme method
    private static int extreme(int[][] mat, int i, int j, int currentMax, boolean[][] visited) {
        int length = mat.length;

        if (i == length - 1 && j == length - 1) return currentMax; // If last cell, return curr max
        currentMax = Math.max(currentMax, mat[i][j]); // Update the curr max value
        visited[i][j] = true; // Mark the curr cell as visited

        // Initialize the min extreme value
        int minExtreme = Integer.MAX_VALUE;

        // Recursively check all valid neighbors
        if (isValid(mat, visited, i + 1, j)) { // Down
            minExtreme = Math.min(minExtreme, extreme(mat, i + 1, j, currentMax, visited));
        }
        if (isValid(mat, visited, i - 1, j)) { // Up
            minExtreme = Math.min(minExtreme, extreme(mat, i - 1, j, currentMax, visited));
        }
        if (isValid(mat, visited, i, j + 1)) { // Right
            minExtreme = Math.min(minExtreme, extreme(mat, i, j + 1, currentMax, visited));
        }
        if (isValid(mat, visited, i, j - 1)) { // Left
            minExtreme = Math.min(minExtreme, extreme(mat, i, j - 1, currentMax, visited));
        }

        // Reset the current cell to unvisited for other paths
        visited[i][j] = false;
        return minExtreme;
    }

    // Checks if a cell is valid
    private static boolean isValid(int[][] mat, boolean[][] visited, int i, int j) {
        return i >= 0 && i < mat.length && j >= 0 && j < mat.length && !visited[i][j];
    }
}