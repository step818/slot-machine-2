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
    public ArrayList<Symbol> spinReel(int mybet) {
        //  create a list that will be the playline
        playline = new ArrayList<>();
        if (isValidBet(mybet)) {
            setBet(mybet);
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
        } else {
            System.out.println("Invalid bet: " + bet + ". Bet must be between " + MIN_BET + " and " + MAX_BET + ".");
            return false;
        }
    }

    public void begin() throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        // Credits are defaulted to 100
//        TODO: Save player name. System.out.println("Please enter your name?");
//        String playerName = scan.nextLine();
        // Variable to keep the while loop going
        String keepPlaying = "Y";
        while(this.getCredits() > 0  && !keepPlaying.equals("E")) {
            System.out.println("Enter 'bet' between (1-20). Then hit Enter to pull crank.");
            // scan bet from player
//            int bet = scan.nextInt();
            // Check If the 'bet' is an integer.
            if(scan.hasNextInt()) {
                int bet = scan.nextInt();
                // If not integer, redirect the user to Enter valid bet
                // Spin the reels
                if(!isValidBet(bet)) {
                    // Redirect player to enter bet
                    this.begin();
                }
                // TODO: Fix bug when user input is out of bounds and Exits app
                ArrayList<Symbol> currentSpin = this.spinReel(bet);

                System.out.println("You bet: " + bet + " credits...");
                System.out.println("Reels are spinning...");
                System.out.print("     ");
                TimeUnit.SECONDS.sleep(2);
                for (Symbol sym: currentSpin) {
                    System.out.print(sym + " ");
                    TimeUnit.MILLISECONDS.sleep(750);
                }
                System.out.println();
                TimeUnit.SECONDS.sleep(1);
                // Display the player's current credits, most recent bet, an
                printWinnings();
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println("Your total coins: " + this.getCredits());
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println("Type any key and hit Enter to continue, or type 'E' to EXIT");
                keepPlaying = scan.next();

            } else {
                System.out.println("Invalid input. Only accepts integers between 1 - 20");
                // Redirect player to enter bet
                this.begin();
            }
        }
        // Game over when player loses all credits
        if(this.getCredits() == 0) {
            System.out.println("You lost all your credits. GAME OVERRRRRRRRRRRR!!!!!!!!!!!!");
        }
        System.out.println("Player has ended the machine. Good Bye!");
        scan.close();
    }
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