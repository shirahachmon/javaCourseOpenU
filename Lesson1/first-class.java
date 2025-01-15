package Lesson1;

import java.util.Scanner;

class QuickStart {
    
    public static void main (String[] args) {
        
        Scanner scan= new Scanner(System.in);

        
        // Int number as an input from the user.
        // int num1; 
        // System.out.println("Enter integar number");
        // num1= scan.nextInt();
        // System.out.println("Num1=" + num1);

        // Double number as an input from the user.
        // double num2; 
        // System.out.println("Enter double number");
        // num2= scan.nextDouble();
        // System.out.println("Num2=" + num2);

        // Char as an input from the user.
        // char ch; 
        // System.out.println("Enter one character");
        // ch= scan.next().charAt(0); // next() returns string
        // System.out.println("ch=" + ch);

        // String firstName, lastName; 
        // System.out.println("Enter your first number");
        // firstName= scan.nextLine(); 
        // System.out.println("Enter your last number");
        // lastName= scan.next(); 
        // System.out.println("First name=" + firstName + ". Last name=" + lastName );

        /** Sample divisions
         * including casting (double), (int). 
         *  */
        // int i=7; int j=2;
        // int k=i/j; // gives 3
        // double d=(double)i/ (double)j; // gives 3.5
        // double oops= (double) (i/j); // gives 3.0
        // double shortcut= (double) i/j; // gives 3.5. j is promoted to double automatically. 

        // The String class:
        // System.out.print("The sum is: " + 20+30 );// returns The sum is:2030
        // System.out.print("The sum is: " + (20+30) );// returns The sum is:50
        // System.out.print("The sum is: " + 100 + "\n" );// returns The sum is:100 [enter]

        /** Example:
         * For every product you buy you have to pay VAT,
         * the value of which is determined by the state and changes every few years. 
         * We will write a program that receives the price of a product 
         * and displays its price after adding the VAT.
         */
        double price, totalPrice;
        final double tax= 0.17;
        System.out.println("Please enter the product's price: ");
        price= scan.nextDouble();
        totalPrice= price*(1+tax);
        System.out.println("The price including 0.17% tax is " + totalPrice);
    }
}