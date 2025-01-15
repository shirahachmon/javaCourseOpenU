package MMN13;

/**
 * @author Shira Hachmon 
 */

public class SpecialArr {
    
    /** 
     * All elements in odd indexes must be smaller than their two neighbors.
     * All members in even indexes must be greater than their two neighbors.
     */

     /** First we will have to get the sorted array to handle the median */
    public static int[] specialArr(int[] arr, int med){
        int[] sortedArr = arr.clone();  // לא לשנות את המערך המקורי

        // Sorting the array using recursive function. 
        quickSort(sortedArr, 0, sortedArr.length - 1);

        int[] result = new int[arr.length];

        // שלב 3: מילוי המערך המיוחד
        int left = 0;  // אינדקס לאיברים הקטנים
        int right = arr.length - 1;  // אינדקס לאיברים הגדולים

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                // במיקומים זוגיים, נשים את האיברים הגדולים
                result[i] = sortedArr[right--];
            } else {
                // במיקומים אי-זוגיים, נשים את האיברים הקטנים
                result[i] = sortedArr[left++];
            }
        }

        return result;
    } 

    // Sorting an array using recursive function  
    // O(nlogn) one of the best practice sorting way on an array. 
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // בוחרים את הפיבוט להיות האיבר האחרון
        int i = low - 1; // אינדקס של האיבר הקטן ביותר שמצאנו עד כה
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;

                // Swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
