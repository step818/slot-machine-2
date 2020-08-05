package com.casino.games;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class SlotMachine {
    // FIELDS
    private static final int MAX_BET = 20;
    private static final int MIN_BET = 1;
    private static ArrayList<Symbol> playline;
    private static int currentCreditsWon = 0;
    private static int coinTray = 0;
    private int credits = 100;

    private int bet = 0;
    private int insertCoin = 0;
    private boolean cashOut = false;

    //BUSINESS METHODS
    public ArrayList<Symbol> spinReel(int bet) {
        //  create a list that will be the playline
        playline = new ArrayList<>();
        if (isValidBet(bet)) {
            setBet(bet);
            //  instantiate the amount of Reels you want for the playline
            Reel reel1 = new Reel();
            Reel reel2 = new Reel();
            Reel reel3 = new Reel();
            //  change the symbol on each reel to some random Symbol
            Symbol symbol1 = reel1.assignSymbol();
            Symbol symbol2 = reel2.assignSymbol();
            Symbol symbol3 = reel3.assignSymbol();
            // place each reel in to the playline list
            playline.add(symbol1);
            playline.add(symbol2);
            playline.add(symbol3);
            // Compare the symbols and calculate the Earnings
            setCurrentCreditsWon(checkWinnings(playline));
        }
        return playline;
    }

    public int checkWinnings(ArrayList<Symbol> playline) {
        // Retrieve the playline result and check to see if the player has won
        currentCreditsWon  = 0;
        // The playline ArrayList looks like: { "&", "@", "?" }
        // if player gets 3 matching
        if (playline.get(0) == playline.get(1) && playline.get(0) == playline.get(2)) {
//            three are equal pay me
//              compareSymbol(playline)
              //Pay appropriately
            currentCreditsWon = bet *50;
        } else if(playline.get(0) == playline.get(1) ||  // if player gets any 2 matching
                playline.get(1) == playline.get(2) ||
                playline.get(0) == playline.get(2)){
//            two are equals
//            currentCreditsWon = getWinnings(playline);
            currentCreditsWon = bet*10;
        }
        setCredits((credits + currentCreditsWon - bet));
        return currentCreditsWon;
    }

    public boolean isValidBet(int bet) {
        if (bet >= MIN_BET && bet <= MAX_BET) {
            return true;
        } else {
            System.out.println("Invalid bet: " + bet + ". Bet must be between " + MIN_BET + " and " + MAX_BET + ".");
            return false;
        }
    }

    public void begin() throws InterruptedException {
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to the Slot Machine! You have 100 credits.");
        // Credits are defaulted to 100
        // Prompt the user for a limited bet amount
        String keepPlaying = "Y";
        while(this.getCredits() > 0  && !keepPlaying.equals("E")) {
            System.out.println("Enter bet. Then hit Enter to pull crank.");

            int bet = scan.nextInt();

            // Spin the reels
            ArrayList<Symbol> currentSpin = this.spinReel(bet);

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
            System.out.println(this.toString());
            System.out.println("Player's total credits: " + this.getCredits());
            System.out.println("Enter 'E' to EXIT, or any button to CONTINUE.");
            keepPlaying = scan.next();
        }

        if(this.getCredits() == 0) {
            System.out.println("You lost all your credits. GAME OVERRRRRRRRRRRR!!!!!!!!!!!!");
        }
        System.out.println("Player has ended the machine. Good Bye!");
        scan.close();
        //  After a few seconds of the reel spinning
        //  Display the three slots on the console
        //  After one second, Announce to the player
        //  If they have won, and the amount they won
        // Add the amount to the Credits
        //  Ask the player if they would like to
        // place another bet. Repeat
        //
        // The machine will End when the player runs out of credits
        // Prompt the user to play again or Exit.

    }

    // ACCESSOR METHODS
    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public int getInsertCoin() {
        return insertCoin;
    }

    public void setInsertCoin(int insertCoin) {
        this.insertCoin = insertCoin;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public static int getCurrentCreditsWon() {
        return currentCreditsWon;
    }

    public static void setCurrentCreditsWon(int currentCreditsWon) {
        SlotMachine.currentCreditsWon = currentCreditsWon;
    }

    public boolean isCashOut() {
        return cashOut;
    }

    public void setCashOut(boolean cashOut) {
        this.cashOut = cashOut;
    }

    public static int getCoinTray() {
        return coinTray;
    }

    public static void setCoinTray(int coinTray) {
        SlotMachine.coinTray = coinTray;
    }

    @Override
    public String toString() {
        return "SlotMachine{" +
                "bet=(current inserted amount)= " + bet +
                ", insertCoin=(has user inserted a coin)= " + insertCoin +
                ", \ncurrentCreditsWon=(the current round's winnings)= " + currentCreditsWon +
                ", cashOut=(has user requested to withdraw the coinTray)= " + cashOut +
                '}';
    }
}