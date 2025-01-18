

package MMN13;

/**
 * @author Shira Hachmon 
 */

public class NearlyPalindrome {

    /** Recursive function 
     * Checks if a subarray is a palindrome
    */
    public static boolean isPalindromeR(int[] arr, int left, int right) {
        // Base case: when the left and right pointers cross each other
        if (left >= right) return true;  
        
        // Compare elements at the left and right if they don't match, it's not a palindrome
        if (arr[left] != arr[right]) return false; 
        
        // Recursively check the inner subarray (excluding the left and right elements)
        return isPalindromeR(arr, left + 1, right - 1);
    }

    /** Recursive function 
     * finds the longest nearly-palindromic subarray
    */
    public static int longestNearlyPalR(int[] arr, int left, int right) {
        // Base case; when the left index is greater than or equal to the right index
        if (left >= right) return 0;

        // If the subarray from left to right is already a palindrome, return its length
        if (isPalindrome(arr, left, right)) return right - left + 1; 

        // Option 1: Remove the element at the left index and check the remaining subarray
        int removeLeft = longestNearlyPalRecursive(arr, left + 1, right);

        // Option 2: Remove the element at the right index and check the remaining subarray
        int removeRight = longestNearlyPalRecursive(arr, left, right - 1);

        // Return the max length of the two options (remove left or remove right)
        return Math.max(removeLeft, removeRight);
    }

    // Main function. 
    public static int longestNearlyPal(int[] arr) {  return longestNearlyPalRecursive(arr, 0, arr.length - 1);}
}