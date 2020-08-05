package com.casino.client;

import com.casino.games.SlotMachine;
import com.casino.games.Symbol;

import java.awt.image.ShortLookupTable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

class Player {
    public static void main(String[] args) {
        SlotMachine game = new SlotMachine();

        // Create a scanner
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Slot Machine! You have 100 credits.");
        // Credits are defaulted to 100
        // Prompt the user for a limited bet amount
        System.out.println("Enter bet. Then hit Enter to pull crank.");

        int bet = scan.nextInt();
        // Spin the reels
        ArrayList<Symbol> currentSpin = game.spinReel(bet);

        System.out.println("You bet: " + bet + " credits...");
        System.out.println("Reels are spinning...");;

        System.out.println("*************" + currentSpin + "*************");
        System.out.println("The currentCreditsWon: " + SlotMachine.getCurrentCreditsWon());
        System.out.println(game.toString());

        System.out.println("Player's total credits: " + game.getCredits());





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
