package com.casino.games;

import java.util.*;

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
            Reel display = new Reel();
            //TODO: Refactor Reel by creating 3 reels that make up 1 display instead of
            // creating one display with 3 slots/"reels" with repeating code
//            Reel reel2 = new Reel();
//            Reel reel3 = new Reel();
            //  change the symbol on each reel to some random Symbol
            Symbol symbol1 = display.assignSymbol1();
            Symbol symbol2 = display.assignSymbol2();
            Symbol symbol3 = display.assignSymbol3();
//            reel2.getRandom();
//            reel3.getRandom();
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
        int currentBet = getBet();
        // Retrieve the playline result and check to see if the player has won
        currentCreditsWon  = 0;
        // The playline ArrayList looks like: { "&", "@", "?" }
        if (playline.get(0) == playline.get(1) && playline.get(0) == playline.get(2)) {
//            three are equal pay me
//              compareSymbol(playline)
              //Pay appropriately
            currentCreditsWon = 50;

        } else if(playline.get(0) == playline.get(1) ||
                playline.get(1) == playline.get(2) ||
                playline.get(0) == playline.get(2)){
//            two are equals
//            currentCreditsWon = getWinnings(playline);
            currentCreditsWon = 10;
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
                ", currentCreditsWon=(the current round's winnings)= " + currentCreditsWon +
                ", cashOut=(has user requested to withdraw the coinTray)= " + cashOut +
                '}';
    }
}
