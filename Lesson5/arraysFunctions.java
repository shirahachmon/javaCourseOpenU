public class arraysFunctions {

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

}
