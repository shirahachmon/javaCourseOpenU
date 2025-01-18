package MMN13;

/**
 * @author Shira Hachmon 
 */

public class First {
    // סיבוכיות מקום של O(1)
    // סיבוכיות זמן ריצה של O(n)

    // This function finds the smallest missing positive integer from an unsorted array of integers. 
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
}
