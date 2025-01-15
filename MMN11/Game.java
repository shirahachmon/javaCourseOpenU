package MMN11;
import java.util.Scanner;

// MAMAN 11

class Game {

    /** Rock paper & scissors game. */
    public static void main (String[] args) {

        /* Scanning the 2 inputs from the players.  */ 
        Scanner scan = new Scanner (System.in);
        System.out.println("Enter first player's object:");
        char player1 = scan.next().charAt(0);
        System.out.println("Enter second player's object:");
        char player2 = scan.next().charAt(0); 

        /** Creating final characters properties, 
         * to avoid multiple quotation marks in the code, for a cleaner look. 
         */
        final char S='S'; 
        final char R='R'; 
        final char P='P';

        /** First check if the two players enter the same char, and if so- it's a tie. */
        if(player1==player2) 
            System.out.println("Game ends with a tie.");
        else if((player1==S && player2==P ) || (player1==R && player2==S) || (player1==P && player2==R))
            System.out.println("Player 1 wins."); // Checking the 3 scenerios for player 1 to win.
        else System.out.println("Player 2 wins."); // Otherwise, player 2 is the winner. 
    }
}