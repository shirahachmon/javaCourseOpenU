// public class quicksort {
    
    
//     // Sorting an array using recursive function  
//     // O(nlogn) one of the best practice sorting way on an array. 
//     public static void quickSort(int[] arr, int low, int high) {
//         if (low < high) {
//             int pivotIndex = partition(arr, low, high);
//             quickSort(arr, low, pivotIndex - 1);
//             quickSort(arr, pivotIndex + 1, high);
//         }
//     }

//     /** The partition function is a key part of the QuickSort algorithm that rearranges 
//      * the array so that elements smaller than the pivot are to the left, and those larger are to the right.
//      *  It returns the new index of the pivot element after partitioning. */
//     private static int partition(int[] arr, int low, int high) {
//         int pivot = arr[high]; // בוחרים את הפיבוט להיות האיבר האחרון
//         int i = low - 1; // אינדקס של האיבר הקטן ביותר שמצאנו עד כה
//         for (int j = low; j < high; j++) {
//             if (arr[j] < pivot) {
//                 i++;

//                 // Swap
//                 int temp = arr[i];
//                 arr[i] = arr[j];
//                 arr[j] = temp;
//             }
//         }

//         int temp = arr[i + 1];
//         arr[i + 1] = arr[high];
//         arr[high] = temp;
//         return i + 1;
//     }
// }
