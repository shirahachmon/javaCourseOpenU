package MMN11;
import java.util.Scanner;

// MAMAN 11

class MaxLine {

    /**
     * Write a program that accepts 3 points in a plane 
     * and finds the greatest distance between the two of them.   
     */

    public static void main (String[] args) {

        /* Scanning the 3 points from the user.  */ 
        Scanner scan = new Scanner (System.in);

        System.out.println("Enter first point coordinates:");
        int x1 = scan.nextInt();
        int y1 = scan.nextInt();
        
        System.out.println ("Enter second point coordinates:");
        int x2 = scan.nextInt();
        int y2 = scan.nextInt();
        
        System.out.println ("Enter third point coordinates:");
        int x3 = scan.nextInt();
        int y3 = scan.nextInt(); 


        /**  Calculating the three distances by the Math class,
         *  by the formula for calculating the distance between two points. 
         */ 
        double disatnceAB= Math.sqrt((Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2)));
        double disatnceBC=Math.sqrt((Math.pow(x2-x3, 2) + Math.pow(y2-y3, 2)));
        double disatnceAC=Math.sqrt((Math.pow(x1-x3, 2) + Math.pow(y1-y3, 2)));

        /** Important! Also if there is 2 greatest distance that are with the same length-
         * as the following in the question, we will log the -first- calculated distance. 
         */
        if(disatnceAB>=disatnceBC && disatnceAB>=disatnceAC)
            System.out.println ("Max line created by the following points: (" + x1 + ","+ y1+"), (" + x2 + ","+ y2+").");
        else if(disatnceBC>=disatnceAB && disatnceBC>=disatnceAC)
            System.out.println ("Max line created by the following points: (" + x2 + ","+ y2+"), (" + x3 + ","+ y3+").");
        else 
            System.out.println ("Max line created by the following points: (" + x1 + ","+ y1+"), (" + x3 + ","+ y3+").");
    }
}