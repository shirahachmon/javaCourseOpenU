package Lesson4;
public class BigO {

    /** Lesson 4 */

    /** חיפוש בינארי מאפשר למצוא את מיקום האיבר ביעילות נמוכה במידה ניכרת */
    // O(log2n)
    public boolean binarySearch(int[] arr, int key){
        int low=0;
        int high=arr.length-1;
        while(high>=low){
            int middle= (low+high)/2;
            if(arr[middle]==key) return true;
            if(arr[middle]<key) low=middle+1;
            if(arr[middle]>key) high=middle-1;
        }
        return false;
    }

    /** O(n(log(n))^2) */
    public void nlog2O(int n){
        for (int i = n; i >0; i/=2) {
            for (int j = 1; j <n; j*=2) {
                for (int k = 0; k<n; k+=2) {
                    /** The inner for loop is with O(n) */
                    /** The middle for loop is with O(logn) */
                    /** The outer for loop is with O(logn) */
                }
            }
        }
    }
    
    /** O(logn) */
    public void logn(int n){
        int i=n;
        while(i>=1){
            if(i%2==0) System.out.print(i);
            else{
                System.out.print("**");
                System.out.print(i);
            }
            i=i/2;
        }
    }

    /** O(nlogn) */
    public void nlogn(int n){
        int x = 1;
        for (int i = 1; i <= n; i++) {
            int m = n;
            for (int j = 1; j <= m; j++) {
                x = x * i;
                m = m / 2;
            }
        }
        System.out.print(x);
    }

    /** Sort an array 
     * O(n^2)
     */
    public static int[] quickSort(int[] a) {
        boolean swap = true;
        for (int i = a.length - 1; (i > 0) && (swap); i--) {
            swap = false;
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    swap = true;
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        return a;
    }

    /** O(nlog4n) */
    public void something(int n) {
        for (int i = n; i > 0; i--) {
            int j = n;
            while (j > 0)
                j = j / 4;
        }
    }
    

    /** מערך חד ממדי בגודל n
     * מכילים מספרים שלמים מ-0 ועד m
     * מחזירה אמת אם אחד מהמספרים מופיעים יותר מפעם אחת
     * אחרת יוחזר שקר
     */
    /** O(n^2) */
    // public static boolean dup(int[] a, int m){
    //     for (int i = 0; i < a.length; i++) 
    //         for (int j =i+1; j <a.length; j++) 
    //             if(a[i]==a[j]) return true;
    //    return false;
    // }
    /** O(nlogn) */
    // public static boolean dup(int[] a, int m){
    //     a= quickSort(a); //O(nlogn)
    //     for(int i=0; i<a.length-1; i++) //O(n)
    //         if(a[i]==a[i+1]) return true;
    //     return false;
    // }
    /** O(n)- best practice!  */
    public static boolean dup(int[] a, int m){
        if(a.length>m+1) return true;
        boolean[] d= new boolean[m+1];
        for(int i=0; i<d.length; i++)
            d[i]=false;
        for(int i=0; i<a.length; i++){
            if(d[a[i]]==true) return true;
            else return d[a[i]]=true;
        }
        return false; 
    }


    /** נתון מערך ממוין בסדר עולה שעבר הזזה S כלשהי 
     * גודלו של S אינו ידוע
     * יש להחזיר את מיקומו של המקסימום במערך 
     */
    /** O(logn) */
    public static int findMax(int[] arr){
        int low=0;  
        int high=arr.length-1;
        int mid; 

        if(arr[high]>arr[low]) return high;
        while(low<=high){ 
            mid=(low+high)/2;
            if(arr[mid]> arr[mid+1]) return mid;
            if(arr[mid]> arr[low]) low=mid+1;
            else high=mid-1;
        }
        return -1; 
    }

    /** פעולה המקבלת מערך דו ממדי ומחזירה אמת אם המערך ממוין לפי שורות ועמודות ושקר אם לא */
    /** O(n^2) */
    public static boolean isSorted(int[][] mat){
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length-1; j++){
                if(mat[i][j]>=mat[i][j+1]) return false;
            }
        }

        for(int i=0; i<mat.length-1; i++){
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j]>=mat[i+1][j]) return false;
            }
        }
        return true;
    }

    /** פעולה מקבלת מערך דו ממדי ממויין לפי שורות ועמודות
     * וגם מקבל ערך מסוים
     * ומחזיר כמה פעמים ערך זה נמצא במטריצה
     */
    // O(n^2)
    // public static int countNum(int[][] mat, int number){
    //     int count=0;
    //     for(int row=0; row<mat.length; row++){
    //         for(int col=0; col<mat[0].length; col++){
    //             if(mat[row][col]==number) count++;
    //         }
    //     }
    //     return count;
    // }

    /** O(logn) best practice! */
    public static int countNum(int[][] mat, int number){
        int row=0;
        int col=mat[0].length-1;
        int count=0;

        while(row<mat.length && col>=0){
            if(mat[row][col]>number) col--;
            if(mat[row][col]<number) row++;
            if(mat[row][col]==number){
                count++;
                row++;
                col--;
            }
        }
        return count;
    }

    /** מקבלים מערך ממוין בסדר עולה ומספר שלם
     * יש להדפיס את כל הזוגות במערך שההפרש בניהם שווה למספר 
     */
    // O(n^2)
    // public static void printPairsA(int[] arr, int k){
    //     for(int i=0; i<arr.length; i++){
    //         for(int j=i+1; j<arr.length; j++){
    //             if(arr[j]-arr[i]==k) System.out.println(arr[i]+","+arr[j]);
    //         }
    //     }
    // }

    /** Lesson 5 */
    /** BEST PRACTICE LINEAR- O(logn) */
    public static void twoSumSearchInSortedArray(int[] array, int value) {
        int bottom = 0, top = array.length - 1;
    
        while (bottom < top) {
            System.out.println("Checking: " + array[bottom] +
                    " at " + bottom + " plus " + array[top] +
                    " at " + top + " sum to " + (array[bottom] + array[top]));
    
            if (array[bottom] + array[top] == value) {
                System.out.println("Found: " + array[bottom] +
                        " at " + bottom + " plus " + array[top] +
                        " at " + top + " sum to " + value);
                return;
            }
    
            if (array[bottom] + array[top] > value) top--;
            else bottom++;
        }
    
        System.out.println("Sum " + value + " was not found.");
    }

    /** This function return true if all values in A are smaller than values in B. Otherwise return false.
     *  O(n^2) */
    public static boolean f(int[] arrayA, int[] arrayB){
        for (int i = 0; i < arrayA.length; i++) {
            for (int j = 0; j < arrayB.length; j++) {
                if (arrayA[i] >= arrayB[j])
                    return false;
            }
        }
        return true;
    }
    /* BETTER PRACTICE WAY: 
    * if we just sort both of the arrays and then check if A[0]<B[B.length-1] - if so return true, else return false;
    * Or just find MIN value in B, and MAX value in A and then return maxA<minB
    * and this will be O(n)
    */
    

    /** כתיבת פונקציה המקבלת סדרה עולה ומנקודה מסוימת יורדת
     * וצריכה להחזיר את הערך בו הפונקציה מתחילה לרדת משמע את הערך הגבוה מבין המערך
     */
    /** O(n) */
    // public static int f(int[] array){
    //     int temp= array[0];
    //     for(int i=0; i<array.length; i++)
    //         if(array[i]>temp) temp= array[i];
    //     return temp; 
    // }
    /** We can develope this function in better complexity rather then O(n)
     * This is half sorted array, therefore we can use binary search with O(logn)
     */
    public static int findMaxValueInHalfSortedArray(int[] array){
        // 2 edge cases:
        if(array[0]>array[1]) return array[0]; // if first index is greater then the second so thats it we have already the answer. 
        if(array[array.length-1]>array[array.length-2]) return array[array.length-1]; // if last index is greater then the previus so thats it we have already the answer. 

        int low=0;
        int high= array.length-1; 
        int mid=-1; 
        
        /** while low is smaller than high */
        while(low<=high){
            mid= (low+high)/2; // binary search in the middle of the edges
            if(array[mid+1] < array[mid] && array[mid-1]< array[mid]) return array[mid];
            else if(array[mid+1]>array[mid]) low=mid+1;
            else if(array[mid-1]>array[mid]) high=mid-1;
            else System.err.println("ERROR");
        }

        return array[mid];
    }

    /** return first all of the values that %4==0
     * then all values %4==1
     * then all values %4==2
     * then all values %4==3
     */
    /** O(n^2) */
    // public static void sortByFour(int[] array){
    //     for (int i = 0; i < array.length - 1; i++) {
    //         int index = i;
    //         for (int j = i + 1; j < array.length; j++) {
    //             if (array[j] % 4 < array[index] % 4)
    //                 index = j;
    //         }
    //         int smallerNumber = array[index];
    //         array[index] = array[i];
    //         array[i] = smallerNumber;
    //     }
    // }
    /** O(n) */
    // public static void sortByFour(int[] array){
    //     int temp;
    //     int x=0;
    //     for(int i=0; i<4; i++){
    //         for(int j=0; j<array.length-1; j++){
    //             if(array[j]%4==i){
    //                 temp=array[x]; /** store the indexed value changed and swap*/
    //                 array[j]= temp;
    //                 x++;
    //             }
    //         }
    //     }
    // }
    /** Id i want to do the exact thing but with k and not specific 4 so just replace from 4 to k */
    public static void sortByFour(int[] array, int k){
        int temp;
        int x=0;
        for(int i=0; i<k; i++){
            for(int j=0; j<array.length-1; j++){
                if(array[j]%k==i){
                    temp=array[x]; /** store the indexed value changed and swap*/
                    array[j]= temp;
                    x++;
                }
            }
        }
    }



    public static void main (String[] args) {

        int[] arrayA = {1,3,5,6,8,123,211,200,15,1};
        int ans= findMaxValueInHalfSortedArray(arrayA);
        System.out.println(ans);

    }
}


