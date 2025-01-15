/** Lesson 5  */

/** Three conditions to use recursive:
תנאי בסיס (Base Case): כל פונקציה רקורסיבית חייבת לכלול תנאי עצירה שמפסיק את הקריאה הרקורסיבית.
קריאה חוזרת: הפונקציה קוראת לעצמה תוך הקטנה של הבעיה.
אופטימיזציה: חשוב להימנע מעודף קריאות רקורסיביות שעלולות לגרום לבעיות זיכרון.
*/

/** פירוק מספר */
/** מחרוזות */
/** מערכים */
/** עצים בינארים */
/** שרשרת חוליות */

public class Recursive {

    /** פירוק מספר */
    /** Gets a number and returns the number of digits. */
    public static int numOfDigits(int number){
        if(number<10) return 1;
        return 1+ numOfDigits(number/10);
    }

    /** Returns the sum of all digits in a number. */
    public static int sumOfDigits(int number){
        if(number<10) return number;
        return number%10+ sumOfDigits(number/10);
    }
    
    /** Check if digit exists in a number. */
    public static boolean isNumExists(int number, int digit){
        if(number<10) return number==digit;
        return number%10==digit ||  isNumExists(number/10, digit);
    }

    /** Returns true if all digits are even numbers. */
    public static boolean isAllEven(int number){
        if(number<10) return number%2==0;
        return (number%10)%2==0 && isAllEven(number/10);
    }

    /** Find max digit in a number by using recursive function and Math.max */
    public static int maxDigit(int number){
        if(number<10) return number;
        return Math.max(number%10, maxDigit(number/10));
    }

    /** ------------------------------------------------------------------------------------------------------- */
    /** Additional Recursive problems */

    // 2. Check if a string is a palindrome
    // This function checks if a given string is a palindrome (same forwards and backwards).
    // public static boolean isPalindrome(String str, int start, int end) {
    //     if (start >= end) return true;
    //     if (str.charAt(start) != str.charAt(end)) return false;
    //     return isPalindrome(str, start + 1, end - 1);
    // }

    // 3. Product of all numbers in an array
    // This function calculates the product of all elements in an array.
    public static int productOfArray(int[] array, int index) {
        if (index == array.length) return 1;
        return array[index] * productOfArray(array, index + 1);
    }

    // 5. Find the minimum value in an array
    // This function finds the smallest value in an array.
    public static int findMin(int[] array, int index, int currentMin) {
        if (index == array.length) return currentMin;
        return findMin(array, index + 1, Math.min(currentMin, array[index]));
    }

    // 6. Power of a number
    // This function calculates a^b (a raised to the power of b).
    public static int power(int a, int b) {
        if (b == 0) return 1;
        return a * power(a, b - 1);
    }

    // 7. Check if an array is sorted
    // This function checks if the elements of an array are in ascending order.
    public static boolean isSorted(int[] array, int index) {
        if (index == array.length - 1) return true;
        if (array[index] > array[index + 1]) return false;
        return isSorted(array, index + 1);
    }

    // 8. Sum of even numbers in an array
    // This function calculates the sum of all even numbers in an array.
    public static int sumEven(int[] array, int index) {
        if (index == array.length) return 0;
        if (array[index] % 2 == 0) return array[index] + sumEven(array, index + 1);
        return sumEven(array, index + 1);
    }

    // 9. Factorial of a number
    // This function calculates the factorial (n!) of a number.
    public static int factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }

    // 10. Search for an element in an array
    // This function checks if a target number exists in an array.
    // הפונקציה מחפשת מספר במערך ומחזירה אם הוא קיים.
    public static boolean search(int[] array, int index, int target) {
        if (index == array.length) return false;
        if (array[index] == target) return true;
        return search(array, index + 1, target);
    }

    /** ------------------------------------------------------------------------------------------------------- */

    /** Back to lesson 5: */
    /** Recursive arrays functions: */

    /** sum of the arrays values- index at first will be the length of an array. */
    // public static int sumArray(int[] array, int index){
    //     if (index == 0) return 0;
    //     return array[index - 1] + sumArray(array, index - 1);
    // }

    /** Another way to solve this by using the public function that we overrided. */
    private static int sumArray(int[] array, int index){
        if (index == array.length) return 0;
        return array[index] + sumArray(array, index+1);
    }
    public static int sumArray(int[] array){
        return sumArray(array,0);
    }

    /** בגלל שבמערכים אין לנו את הדרך להקטין את הבעיה
     * אז הדרך בה נוכל להקטין את הבעיה יש להוסיף משתנה מזהה מקום 
     * index
     * וכדי לעשות זאת יש לבנות שתי פונקצוית אחת פרטית אחת חיצונית 
     */
    
    public static boolean isPalindrom(String str){
        if(str.length()<2) return true;
        return str.charAt(0)==str.charAt(str.length()-1) && isPalindrom(str.substring(1, str.length()-1));
    }

    /** if abc is the input
     * the output will be abccba
     */
    public static String mirror(String str){
        if(str.equals("")) return str;
        return str.charAt(0) + mirror(str.substring(1)) + str.charAt(0);
    }

    /** We get two strings and we need to return true if those strings are alike 
     * and its ok if maximum one charcter is different
     * but have to be with the same length
     */
    public static boolean isAlmostEquals(String s1, String s2){
        if(s1.length()!=s2.length())return false;
        if(s1.length()==0)return true;
        if(s1.charAt(0)==s2.charAt(0)) 
            return isAlmostEquals(s1.substring(1), s2.substring(1));
        else return s1.substring(1).equals(s2.substring(1));
    }

    /** is number exists in an array
     * There are 2 ways:
     */
    /** 1. */
    // public static boolean isExistInArray(int[] array, int x){
    //     return isExistInArray(array, x, array.length-1);
    // }
    // private static boolean isExistInArray(int[] array, int x, int n){
    //     if(n<0) return false;
    //     if(array[n]==x) return true;
    //     return isExistInArray(array, x, n-1);
    // }
    /** 2. */
    public static boolean isExistInArray(int[] array, int x){
        return isExistInArray(array, x,0);
    }
    private static boolean isExistInArray(int[] array, int x, int n){
        if(n==array.length) return false;
        if(array[n]==x) return true;
        return isExistInArray(array,x, n+1);
    }

    /** Search index in sorted array */
    public static boolean existSorted(int[] arr, int x){
        return existSorted(arr, 0, arr.length-1,x);
    }

    private static boolean existSorted(int[] arr, int left, int right, int x){
        if(left>right) return false;
        int mid= (left+right)/2;
        if(arr[mid]==x) return true;
        if(x<arr[mid]) return existSorted(arr, left, mid-1, x);
        return existSorted(arr, mid+1, right, x);
    }

    /** Fins the minimum value in an array */
    public static int findMinInArray(int[] array){
        return findMinInArray(array, 0);
    }
    
    private static int findMinInArray(int[] array, int index){
        if(index==array.length-1) return array[index];
        return Math.min(array[index], findMinInArray(array, index+1));
    }

    /** Check if sum of the even indexes are equal to sum of the not even indexes. */
    // private
}
