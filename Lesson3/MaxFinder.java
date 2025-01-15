package Lesson3;


// lesson 3

class MaxFinder {
    public static void main (String[] args) {

        /** Classic while loop explenation */
        // int number, max=-1;
        // Scanner scanner = new Scanner(System.in);
        // System.out.println("please enter numbers, and to quit enter -1: ");
        // number= scanner.nextInt();

        // while(number!=-1){
        //     if(number>max) max=number;
        //     System.out.println("please enter numbers, and to quit enter -1: ");
        //     number= scanner.nextInt();
        // }



        /** Calculate all digit Sum */
        // Scanner scanner = new Scanner(System.in);
        // System.out.println("Enter number ");
        // int num= scanner.nextInt();
        // int sum=0, digit;
        // while(num>0){
        //     digit=num%10;
        //     sum+=digit;
        //     num=num/10;
        // }
        // System.out.println("Digits sum: " + sum);
        
        // boolean isPerfectNumber= perfect(5);
        // System.out.println(isPerfectNumber);

    }

    /** Perfect number - sum divides equal to the number itself */
    public static boolean perfect(int number){
        int sum=0, k=1;
        while(k<=number/2){
            if (number%k==0) sum=sum+k;
                 k++;
        }
         return sum==number;
    }
}

