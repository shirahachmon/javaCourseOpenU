

// package MMN13;

/**
 * @author Shira Hachmon 
 */

public class LongestNearlyPal {

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

    public static void main(String[] args){
        System.out.println ("********** Question 3 **********\n");
        int[] array = {1, 1, 4, 10, 10, 4, 3, 10, 10};
        System.out.println("Checking method 'longestNearlyPal' on array " + toString(array));
        int studentResult3 = longestNearlyPal(array);
        System.out.println("Result is: "+studentResult3);
        System.out.println();


    }
    private static String toString(int[] arr)
    {
        String s = "{";
        for(int i=0; i<arr.length-1; i++)
            s+=arr[i]+", ";
        return s+arr[arr.length-1]+"}";
    }
}