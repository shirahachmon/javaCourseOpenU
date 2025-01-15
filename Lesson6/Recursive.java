public class Recursive {
    
    /** חשב אם סכום האיברים הזוגיים שווה לסכום האיברים האי זוגיים */
    public static boolean isEvenEqualOdd(int[] arr){
        if(arr.length==0) return true;
        if(arr.length==1) return false; 
        return isEvenEqualOdd(arr, arr.length-1, 0);
    }
    private static boolean isEvenEqualOdd(int[] arr, int index, int sum){
        if(index<0) return sum==0;
        if(index%2==0) sum+= arr[index];
        else sum-=arr[index]; 
        return isEvenEqualOdd(arr, index-1, 0);
    }

    /** סכום האיברים במקומות האי זוגיים  */
    public static int sumOddIndexes(int[] arr){
        return sumOddIndexes(arr, 1);
    }
    private static int sumOddIndexes(int[] arr, int index){
        if(index> arr.length) return 0;
        if(index==arr.length-1)  return arr[arr.length-1]; 
        return arr[index]+ sumOddIndexes(arr, index+2);
    }

    /** Move negative numbers and 0 to beginning of the array, positive numbers to the end of the array. */
    public static void negPos(int[] arr){
        negPos(arr, 0, arr.length-1);
    }
    private static void negPos(int[] arr, int start, int end){
        if(start>=end) return;
        if(arr[start]<=0) negPos(arr, start+1, end);
        else if(arr[end]>0) negPos(arr, start, end-1);  
        else{
            int temp=arr[start];
            arr[start]= arr[end];
            arr[end]= temp;
            negPos(arr, start+1, end-1);
        }
    }

    /** כמה מסלולים יש מהנקודה 0,0 ל5,4 שפונים רק למעלה וימינה(צפונה ומזרחה)?
     *  שאלה קשה שבו מנסים להכיר את המושג שנקרא back tracking. */
     public static int numberPaths(int x, int y){
        if((x==0) && (y==0)) return 0; 
        if((x==0) || (y==0)) return 1;
        return numberPaths(x-1, y) + numberPaths(x, y-1); 
     }

         // מערך דו ממדי ריבועי 
    /** נקרא משופע אם כל ערכי האלכסון הראשי שווים ל-0
     * אם כל האיברים שנמצאים מתחת לאלכסון הראשי הם שליליים
     * אם כל האיברים שנמצאים מעל האלכסון הראשי הם חיוביים
     */
    /** Write a recursive function that gets matrizza and return if th mat is משופע */
    public static boolean slope(int[][] data, int i){
        // End of the array, last cell, if equal to 0- great
        if(i==data.length-1){
            if(data[i][i]==0) return true;
            return false;
        }

        return (slope(data, i+1) && data[i][i]==0 && check(data, i, i+1));
    }
    /** Check for positive or negative values */
    private static boolean check(int[][] data, int i, int j){
        if(j==data.length) return true;
        if(data[i][j]<=0 || data[j][i]>= 0) return false;
        return check(data, i, j+1);
    }

    /** Function will return true if any of indexes value that their sum equal to the amount parameter. */
    public boolean cover(int[] data, int amount){
        return cover(data, 0, amount);
    }
    private boolean cover(int[] data, int i, int amount){
        if(amount==0) return true;
        if(i==data.length) return false;    
        return cover(data, i+1, amount-data[i]) || cover(data, i+1, amount); 
    }

    /**S קבוצה של מספרים טבעיים שלמים גדולים מאפס
     * ויהי N מספר טבעי
     * נאמר שהמספר הטבעי הוא סכום מתוך הקבוצה אם יהיה ניתן לבטא את הקבוצה כסכום של מספרים מתוך S
     * S={4,5} so n=13 returns true because 4+5+4=13
     */
    public static boolean isSumOf(int[] s, int n){
        return isSumOf(s, n, 0);
    }
    private static boolean isSumOf(int[] s, int n, int i){
        if(n==0)return true;
        if(n<0) return false;
        if(i==s.length) return false;
        return isSumOf(s, n-s[i], i) || isSumOf(s, n, i+1);  
    }

    /** building with n floors, spiderman wants to go upstairs, he can jump up one floor or two.
     * spiderman can also goes up, not down.
     * write recursive functio that gets n floors and calculate count of ways that spiderman can go up to last floor.
     * for example n-4 so answer will be 5 because:
     * one by one - 4 steps
     * two, two - 2 steps
     * two, one, one, one- 4 steps
     * one, one, two- 3 steps
     * one, two, one- 3 steps
     * therefore- 5 different ways
     */
    public static int spiderman(int n){
        if(n<=0) return 0;
        if(n==1) return 1;
        if(n==2) return 2;

        return spiderman(n-1)+ spiderman(n-2);
    }
    /** סעיף ב */
    public static int spidermanPhoneBooth20(int n){
        if(n<=20) return spiderman(n);
        if(n>29) return 0;
        return spiderman(20)+ spiderman(19)*spiderman(n-21); 
    }

    /** function gets mat of numbers greater/equal to 0 but smaller than 100.
     * נגדיר מסלול חוקי במטריצה כסדרה של תאים במערך 
     * המתחילה בתא הראשון 0.0
     * ומתקדמת במערך לפי סדרת האחדות והעשרות של הספרה שבתוך האינדקס, עד לתא האחרון במערך
     * לדוגמא אם בתא 2,3 נמצא המספר 15 אזי מהתא הזה ניתן להתקדם 1 בשורות ו5 בעמודות
     * או 5 בשורות ו1 בעמודות
     * אבל אם המערך עם גודל של 5 ו4 אזי אנחנו נחרוג מהגודל של המערך אזי לא מסלול חוקי
     */
    public static int countPaths(int[][] mat){
        return countPaths(mat, 0, 0); // We need two indexes indentify to work with recursia with mat.
    }
    private static int countPaths(int[][] mat, int row, int col){
        if(row>=mat.length || col>=mat[row].length) return 0;
        if(row==mat.length-1 || col==mat[row].length-1) return 1;
        if(mat[row][col]==0) return 0; // If value is 0 we can't continue with this route

        if(mat[row][col]/10 !=mat[row][col]%10) 
            return (countPaths(mat, row+mat[row][col]/10, col+mat[row][col]%10) + countPaths(mat, row+mat[row][col]%10, col+mat[row][col]/10));
        else return countPaths(mat, row+mat[row][col]/10, col+mat[row][col]%10); 
    }

    /** Recursive function that gets a number and return the minimal count of sum(of 1,5, and 7) 
     * so that we can get the number n using calculating the sum. 
     * n=10 so answer will be 2 because the route 5+5 is the minimal. (we can also use 1+1+1+1+1+1+1+1=10 but this is not minimal)
     */
    public static int oneFiveSeven(int n){
        if(n==0) return 0;
        int temp1=n+1;
        int temp2=n+1;
        int temp3=n+1;

        if(n>=1) temp1= oneFiveSeven(n-1)+1;
        if(n>=5) temp2= oneFiveSeven(n-5)+1;
        if(n>=7) temp3= oneFiveSeven(n-7)+1;

        return Math.min(temp1, Math.min(temp2,temp3));
    }


    // More important questions in the word file- will resolve all functions before the test. 
}
