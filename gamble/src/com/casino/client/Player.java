package com.casino.client;
import com.casino.games.SlotMachine;
import com.casino.games.Symbol;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class Player {
    public static void main(String[] args) throws InterruptedException {
        SlotMachine game = new SlotMachine();
        // Create a scanner
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Slot Machine! You have 100 credits.");
        // Credits are defaulted to 100
        // Prompt the user for a limited bet amount
        String keepPlaying = "Y";
        while(game.getCredits() > 0  && !keepPlaying.equals("E")) {
            System.out.println("Enter bet. Then hit Enter to pull crank.");

            int bet = scan.nextInt();

            // Spin the reels
            ArrayList<Symbol> currentSpin = game.spinReel(bet);

            System.out.println("You bet: " + bet + " credits...");
            System.out.println("Reels are spinning...");
            for (int i = 0; i < 10; i++) {
                System.out.print("* ");
            }
            TimeUnit.SECONDS.sleep(2);
            for (Symbol sym: currentSpin) {
                System.out.print(sym + " ");
                TimeUnit.MILLISECONDS.sleep(750);
            }
            System.out.println();
            TimeUnit.SECONDS.sleep(1);
            System.out.println("The currentCreditsWon: " + SlotMachine.getCurrentCreditsWon());
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println(game.toString());
            System.out.println("Player's total credits: " + game.getCredits());
            System.out.println("Enter 'E' or 'e' to EXIT, or any button to CONTINUE.");
            keepPlaying = scan.next();
        }

        if(game.getCredits() == 0) {
            System.out.println("You lost all your credits. GAME OVERRRRRRRRRRRR!!!!!!!!!!!!");
        }
        System.out.println("Player has ended the game. Good Bye!");
        scan.close();
        //  After a few seconds of the reel spinning
        //  Display the three slots on the console
        //  After one second, Announce to the player
        //  If they have won, and the amount they won
        // Add the amount to the Credits
        //  Ask the player if they would like to
        // place another bet. Repeat
        //
        // The game will End when the player runs out of credits
        // Prompt the user to play again or Exit.

    }
}