
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
    public static int longestNearlyPal(int[] arr) {  return longestNearlyPalRecursive(arr, 0, arr.length - 1);}
    
    /**  Checks if a subarray is a palindrome  */
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

    public static void main(String[] args){
        System.out.println ("********** Question 1 **********\n");
        int[] arr1 = {4, -5, -3, 1, 2, 7, 0};
        int med1 = 1;
        System.out.println("Checking method 'specialArr' on array "+toString(arr1)+" and med = " + med1);
        int[] studentResult1;
        studentResult1 = Ex13.specialArr(arr1, med1);
        System.out.println("Result is: "+toString(studentResult1));
        int result=checkIfSpecial(studentResult1);
        if(result>=0)
        {
            System.out.println ("Error!!! The array is not a special array." );
            System.out.println("The first problematic index is : "+result);

        }
        System.out.println();

        int[] arr2 = {4, -5, -3, 1, 2, 7, 9, 0};
        int med2 = 2;
        System.out.println("Checking method 'specialArr' on array "+toString(arr2)+" and med = " + med2);
        int[] studentResult2;
        studentResult2 = Ex13.specialArr(arr2, med2);

        System.out.println("Result is: "+ toString(studentResult2));
        result=checkIfSpecial(studentResult2);
        if(result>=0)
        {
            System.out.println ("Error!!! The array is not a special array." );
            System.out.println("The first problematic index is : "+result);

        }
        System.out.println();
        System.out.println("Note that these are not the only special arrays that can be created");
        System.out.println();

        System.out.println ("********** Question 2 **********\n");
        int[] arr = new int[]{1, -3, 6, 2, 0, 15};
        System.out.println("Checking method 'first' on array " + toString(arr));
        int studentResult = Ex13.first(arr);
        System.out.println("Result is: "+studentResult);
        System.out.println();

        arr = new int[]{1, 1, 1, 1};
        System.out.println("Checking method 'first' on array " + toString(arr));
        studentResult = Ex13.first(arr);
        System.out.println("Result is: "+studentResult);
        System.out.println();

        arr = new int[]{1, 2, 3, 4};
        System.out.println("Checking method 'first' on array " + toString(arr));
        studentResult = Ex13.first(arr);
        System.out.println("Result is: "+studentResult);
        System.out.println();

        arr = new int[]{5, -1, 3, 1, 0, -2, 2};
        System.out.println("Checking method 'first' on array " + toString(arr));
        studentResult = Ex13.first(arr);
        System.out.println("Result is: "+studentResult);
        System.out.println();

        arr = new int[]{7, 8, 9, 11, 12, 14};
        System.out.println("Checking method 'first' on array " + toString(arr));
        studentResult = Ex13.first(arr);
        System.out.println("Result is: "+studentResult);
        System.out.println();

        System.out.println ("********** Question 3 **********\n");
        int[] array = {1, 1, 4, 10, 10, 4, 3, 10, 10};
        System.out.println("Checking method 'longestNearlyPal' on array " + toString(array));
        int studentResult3 = Ex13.longestNearlyPal(array);
        System.out.println("Result is: "+studentResult3);
        System.out.println();

        System.out.println ("********** Question 4 **********\n");

        int[][] a={{1,2},{3,4}};
        System.out.println("Checking method 'extreme' on array ");
        print(a);
        int studentResult4 = Ex13.extreme(a);
        System.out.println("Result is: "+studentResult4);
        System.out.println();

        int[][] b={{1,3},{4,2}};
        System.out.println("Checking method 'extreme' on array ");
        print(b);
        studentResult4 = Ex13.extreme(b);
        System.out.println("Result is: "+studentResult4);
        System.out.println();

        int[][] c={{4,5,8,2},{3,12,7,16},{13,1,10,14},{15,11,9,6}};
        System.out.println("Checking method 'extreme' on array ");
        print(c);
        studentResult4 = Ex13.extreme(c);
        System.out.println("Result is: "+studentResult4);
        System.out.println();

        int[][] d={{4,5,8,2},{3,12,16,7},{13,1,10,14},{15,11,9,6}};
        System.out.println("Checking method 'extreme' on array ");
        print(d);
        studentResult4 = Ex13.extreme(d);
        System.out.println("Result is: "+studentResult4);
        System.out.println();

    }

    private static String toString(int[] arr)
    {
        String s = "{";
        for(int i=0; i<arr.length-1; i++)
            s+=arr[i]+", ";
        return s+arr[arr.length-1]+"}";
    }

    private static void print(int[][] arr)
    {
        for(int i=0; i<arr.length; i++)
        {
            for(int j = 0; j < arr[i].length-1; j++)
                System.out.print(arr[i][j]+"\t");
            System.out.println(arr[i][arr[i].length-1]);
        }
    }

    private static int checkIfSpecial(int []arr){
        int i;

        for(i=0;i<arr.length-1;i++)
            if(i%2==0)//even place
            {
                if(arr[i]<arr[i+1])//incorrect
                    return i;
            }
            else//odd place
                if(arr[i]>arr[i+1])//incorrect
                    return i;

        return -1;//special array
    }
}