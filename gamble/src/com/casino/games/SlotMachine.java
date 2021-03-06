package com.casino.games;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class SlotMachine {
    // FIELDS
    private static final int MAX_BET = 20;
    private static final int MIN_BET = 1;
    private static ArrayList<Symbol> playline;
    private static int currentCreditsWon = 0;
    private int credits = 100;

    private int bet = 0;

    //BUSINESS METHODS
    public ArrayList<Symbol> spinReel(int mybet) throws InterruptedException {
        //  create a list that will be the playline
        playline = new ArrayList<>();
        if (isValidBet(mybet)) {
            setBet(mybet);
            //  instantiate the amount of Reels you want for the playline
            Reel reel1 = new Reel();
            Reel reel2 = new Reel();
            Reel reel3 = new Reel();
            //  change the symbol on each reel to some random Symbol
            Symbol symbol1 = reel1.easyJackpot();
            Symbol symbol2 = reel2.easyJackpot();
            Symbol symbol3 = reel3.easyJackpot();
            // place each reel in to the playline list
            playline.add(symbol1);
            playline.add(symbol2);
            playline.add(symbol3);
            // Compare the symbols and calculate the Earnings
            setCurrentCreditsWon(checkWinnings(playline));
        }
        return playline;
    }

    public int checkWinnings(ArrayList<Symbol> playline) throws InterruptedException {
        // Retrieve the playline result and check to see if the player has won
        currentCreditsWon  = 0;
        // The playline ArrayList looks like: { "&", "@", "?" }
        // If the player matches three, they will receive an automatic triple bonus (multiply bet times 3 immediately).
        if (playline.get(0) == playline.get(1) && playline.get(0) == playline.get(2) &&
                playline.get(0) == Symbol.AT && playline.get(1) == Symbol.AT && playline.get(2) == Symbol.AT) {
            currentCreditsWon = bet * 6 - bet;
        }
        else if (playline.get(0) == playline.get(1) && playline.get(0) == playline.get(2) &&
                playline.get(0) == Symbol.HASH && playline.get(1) == Symbol.HASH && playline.get(2) == Symbol.HASH) {
            currentCreditsWon = bet * 9 - bet;
        }
        else if (playline.get(0) == playline.get(1) && playline.get(0) == playline.get(2) &&
                playline.get(0) == Symbol.COLON && playline.get(1) == Symbol.COLON && playline.get(2) == Symbol.COLON) {
            currentCreditsWon = bet * 12 - bet;
        }
        else if (playline.get(0) == playline.get(1) && playline.get(0) == playline.get(2) &&
                playline.get(0) == Symbol.QUESTION && playline.get(1) == Symbol.QUESTION && playline.get(2) == Symbol.QUESTION) {
            currentCreditsWon = bet * 12 - bet;
        }
        else if (playline.get(0) == playline.get(1) && playline.get(0) == playline.get(2) &&
                playline.get(0) == Symbol.PERCENT && playline.get(1) == Symbol.PERCENT && playline.get(2) == Symbol.PERCENT) {
            currentCreditsWon = bet * 15 - bet;
        }
        else if (playline.get(0) == playline.get(1) && playline.get(0) == playline.get(2) &&
                playline.get(0) == Symbol.AMPERSAND && playline.get(1) == Symbol.AMPERSAND && playline.get(2) == Symbol.AMPERSAND) {
            currentCreditsWon = bet * 18 - bet;
        }
        else if (playline.get(0) == playline.get(1) && playline.get(0) == playline.get(2) &&
                playline.get(0) == Symbol.BANG && playline.get(1) == Symbol.BANG && playline.get(2) == Symbol.BANG) {
            currentCreditsWon = bet * 21 - bet;
        }
        else if (playline.get(0) == playline.get(1) && playline.get(0) == playline.get(2) &&
                playline.get(0) == Symbol.SEVEN && playline.get(1) == Symbol.SEVEN && playline.get(2) == Symbol.SEVEN) {
            currentCreditsWon = bet * 24 - bet;
        }
        else if (playline.get(0) == playline.get(1) && playline.get(0) == playline.get(2) &&
                playline.get(0) == Symbol.GOLD && playline.get(1) == Symbol.GOLD && playline.get(2) == Symbol.GOLD) {
            currentCreditsWon = bet * 27 - bet;
        }
        else if (playline.get(0) == playline.get(1) && playline.get(0) == playline.get(2) &&
                playline.get(0) == Symbol.DOLLAR && playline.get(1) == Symbol.DOLLAR && playline.get(2) == Symbol.DOLLAR) {
            currentCreditsWon = bet * 300 - bet;
        }
        // Now we go into the algorithm when only two symbols show on the payline. If the player hits two, they will receive a (x2) bonus!
        else if  (playline.get(0) == playline.get(1) && playline.get(0) == Symbol.AT && playline.get(1) == Symbol.AT ||
                playline.get(1) == playline.get(2) && playline.get(1) == Symbol.AT && playline.get(2) == Symbol.AT ||
                playline.get(0) == playline.get(2) && playline.get(0) == Symbol.AT && playline.get(2) == Symbol.AT) {
            currentCreditsWon = bet * 4 - bet;
        }
        else if (playline.get(0) == playline.get(1) && playline.get(0) == Symbol.HASH && playline.get(1) == Symbol.HASH ||
                playline.get(1) == playline.get(2) && playline.get(1) == Symbol.HASH && playline.get(2) == Symbol.HASH ||
                playline.get(0) == playline.get(2) && playline.get(0) == Symbol.HASH && playline.get(2) == Symbol.HASH) {
            currentCreditsWon = bet * 6 - bet;
        }
        else if (playline.get(0) == playline.get(1) && playline.get(0) == Symbol.COLON && playline.get(1) == Symbol.COLON ||
                playline.get(1) == playline.get(2) && playline.get(1) == Symbol.COLON && playline.get(2) == Symbol.COLON ||
                playline.get(0) == playline.get(2) && playline.get(0) == Symbol.COLON && playline.get(2) == Symbol.COLON) {
            currentCreditsWon = bet * 8 - bet;
        }
        else if (playline.get(0) == playline.get(1) && playline.get(0) == Symbol.QUESTION && playline.get(1) == Symbol.QUESTION ||
                playline.get(1) == playline.get(2) && playline.get(1) == Symbol.QUESTION && playline.get(2) == Symbol.QUESTION ||
                playline.get(0) == playline.get(2) && playline.get(0) == Symbol.QUESTION && playline.get(2) == Symbol.QUESTION) {
            currentCreditsWon = bet * 8 - bet;
        }
        else if (playline.get(0) == playline.get(1) && playline.get(0) == Symbol.PERCENT && playline.get(1) == Symbol.PERCENT ||
                playline.get(1) == playline.get(2) && playline.get(1) == Symbol.PERCENT && playline.get(2) == Symbol.PERCENT ||
                playline.get(0) == playline.get(2) && playline.get(0) == Symbol.PERCENT && playline.get(2) == Symbol.PERCENT) {
            currentCreditsWon = bet * 10 - bet;
        }
        else if (playline.get(0) == playline.get(1) && playline.get(0) == Symbol.AMPERSAND && playline.get(1) == Symbol.AMPERSAND ||
                playline.get(1) == playline.get(2) && playline.get(1) == Symbol.AMPERSAND && playline.get(2) == Symbol.AMPERSAND ||
                playline.get(0) == playline.get(2) && playline.get(0) == Symbol.AMPERSAND && playline.get(2) == Symbol.AMPERSAND) {
            currentCreditsWon = bet * 12 - bet;
        }
        else if (playline.get(0) == playline.get(1) && playline.get(0) == Symbol.BANG && playline.get(1) == Symbol.BANG ||
                playline.get(1) == playline.get(2) && playline.get(1) == Symbol.BANG && playline.get(2) == Symbol.BANG ||
                playline.get(0) == playline.get(2) && playline.get(0) == Symbol.BANG && playline.get(2) == Symbol.BANG) {
            currentCreditsWon = bet * 14 - bet;
        }
        else if (playline.get(0) == playline.get(1) && playline.get(0) == Symbol.SEVEN && playline.get(1) == Symbol.SEVEN ||
                playline.get(1) == playline.get(2) && playline.get(1) == Symbol.SEVEN && playline.get(2) == Symbol.SEVEN ||
                playline.get(0) == playline.get(2) && playline.get(0) == Symbol.SEVEN && playline.get(2) == Symbol.SEVEN) {
            currentCreditsWon = bet * 16 - bet;
        }
        else if (playline.get(0) == playline.get(1) && playline.get(0) == Symbol.GOLD && playline.get(1) == Symbol.GOLD ||
                playline.get(1) == playline.get(2) && playline.get(1) == Symbol.GOLD && playline.get(2) == Symbol.GOLD ||
                playline.get(0) == playline.get(2) && playline.get(0) == Symbol.GOLD && playline.get(2) == Symbol.GOLD) {
            currentCreditsWon = bet * 18 - bet;
        }
        else if (playline.get(0) == playline.get(1) && playline.get(0) == Symbol.DOLLAR && playline.get(1) == Symbol.DOLLAR ||
                playline.get(1) == playline.get(2) && playline.get(1) == Symbol.DOLLAR && playline.get(2) == Symbol.DOLLAR ||
                playline.get(0) == playline.get(2) && playline.get(0) == Symbol.DOLLAR && playline.get(2) == Symbol.DOLLAR) {
            currentCreditsWon = bet * 50 - bet;
        }
        else if (playline.get(0) != playline.get(1) && playline.get(1) != playline.get(2) && playline.get(0) != playline.get(2)) {
            currentCreditsWon = currentCreditsWon - bet;
        }
        setCredits((credits + currentCreditsWon));
        return currentCreditsWon;
    }

    public boolean isValidBet(int bet) {
        if (bet >= MIN_BET && bet <= MAX_BET && bet < credits) {
            return true;
        } else if(bet > credits) {
            System.out.println("\033[0;31m" + "Invalid bet: " + bet + ". Not enough credits." + "\033[0m");
            return false;
        }else {
            System.out.println("\033[0;31m" + "Invalid bet: " + bet + ". Bet must be between " + MIN_BET + " and " + MAX_BET + "." + "\033[0m");
            return false;
        }
    }

    public void begin() throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        // Credits are defaulted to 100
//        TODO: Save player name. System.out.println("Please enter your name?");
//        String playerName = scan.nextLine();
        // Variable to keep the while loop going
        String keepPlaying = "";
        while(this.getCredits() > 0  && !keepPlaying.equals("E")) {
            System.out.println("Enter 'bet' between (1-20). Then hit Enter to pull crank.");
            // scan bet from player
            // Check If the 'bet' is an integer.
            int bet = scan.nextInt();
            // If not integer, redirect the user to Enter valid bet
            if(!isValidBet(bet)) {
                // Redirect player to enter bet
                System.out.println("\033[0;31m"+"Out of bounds! Your bet is set to MAX_BET = 20"+"\033[0m");
                bet = MAX_BET;
            }
            // Spin the reels
            ArrayList<Symbol> currentSpin = this.spinReel(bet);
            System.out.println("You bet: " + bet + " credits...");
            System.out.println("Reels are spinning...");
            System.out.print("     ");
            TimeUnit.SECONDS.sleep(2);
            // Display the outcome
            for (Symbol sym: currentSpin) {
                System.out.print(sym + " ");
                TimeUnit.MILLISECONDS.sleep(750);
            }
            checkForJackpot();
            System.out.println();
            TimeUnit.SECONDS.sleep(1);
            // Display the player's current credits, most recent bet, an
            printWinnings();
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("Your total coins: " +"\u001B[32m"+ this.getCredits() + "\u001B[0m");
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("\033[0;34m"+"If you would like to continue, hit any key and Enter."+"\033[0m");
            System.out.println("\033[0;35m"+"If you would like to quit, hit 'E' to Exit."+"\033[0m");
            keepPlaying = scan.next();
        }
        // Game over when player loses all credits
        if(this.getCredits() == 0) {
            System.out.println("You lost all your credits." + "\033[0;31m" + " GAME OVERRRRRRRRRRRR!!!!!!!!!!!!" + "\033[0m");
        }
        System.out.println("Player has ended the machine. " + "\033[0;32m" + "You now have " + credits + " credits." + "\033[0m" + " Good Bye!");
        scan.close();
    }

    public void checkForJackpot() {
        if (playline.get(0) == playline.get(1) && playline.get(0) == playline.get(2) && playline.get(0) == Symbol.DOLLAR && playline.get(1) == Symbol.DOLLAR && playline.get(2) == Symbol.DOLLAR) {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("JACKPOT!!! The machine EXPLODES! You collect your money and run before the casino attempts to tell you that it was a bug.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else if (playline.get(0) == playline.get(1) && playline.get(0) == Symbol.DOLLAR && playline.get(1) == Symbol.DOLLAR ||
        playline.get(1) == playline.get(2) && playline.get(1) == Symbol.DOLLAR && playline.get(2) == Symbol.DOLLAR ||
        playline.get(0) == playline.get(2) && playline.get(0) == Symbol.DOLLAR && playline.get(2) == Symbol.DOLLAR) {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Mini Jackpot! Congratulations! Coins go everywhere!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void getPayoutChart () { // Used to display the payout chart.
        System.out.println("\u001B[34m"+"Here is your payout chart:"+"\u001B[0m");
//        System.out.println();
        System.out.println("\u001B[36m"+"Ratio: $1 = 1 Credit. Calculated by (bet x payout - bet)");
//        System.out.println();
        System.out.println("For landing two symbols on the payline: [@ = 4] [# = 6] [: = 8] [? = 8] [% = 10] [& = 12] [! = 14] [7 = 16] [G = 18] [$ = 100]");
//        System.out.println();
        System.out.println("For landing three symbols on the payline: [@ = 6] [# = 9] [: = 12] [? = 12] [% = 15] [& = 18] [! = 21] [7 = 24] [G = 27] [$ = 900]"+"\u001B[0m");
        System.out.println(); }
    // TODO: Take number of matches and print matches credits won
    public void printWinnings() {
        System.out.println("You won: " + getCurrentCreditsWon() + " coins");
    }

    public void printDisplay() {
        System.out.println("(((Possible symbols include :)))\n((( @ = common, # = common,  % = common,)))\n((( & = common, ? = common , : = common" +
                ",)))\n((( G = rare, 7 = rare, $ = rarest)))");
    }

    // ACCESSOR METHODS
    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
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

    @Override
    public String toString() {
        return "SlotMachine{" +
                "your recent bet= " + bet +
                ", \ncurrentCreditsWon=(the current round's winnings)= " + currentCreditsWon +
                '}';
    }
}