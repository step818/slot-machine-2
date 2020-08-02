package com.casino.games;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class SlotMachine {
    // FIELDS
    private static Collection<Reel> playline;
    private static int coinTray = 0;
    private static int credits = 0;

    private int bet = 0;
    private int insertCoin = 0;
    private int winnerPaid = 0;
    private boolean cashOut = false;

    //BUSINESS METHODS
    public Collection<Reel> spinReel() {
        //  create a list that will be the playline
      playline = new ArrayList<>();
      //  instantiate the amount of Reels you want for the playline
      Reel reel1 = new Reel();
      Reel reel2 = new Reel();
      Reel reel3 = new Reel();
      //  change the symbol on each reel to some random Symbol
      reel1.getRandom();
      reel2.getRandom();
      reel3.getRandom();
      // place each reel in to the playline list
      playline.add(reel1);
      playline.add(reel2);
      playline.add(reel3);

      return playline;
    };

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

    public static int getCredits() {
        return credits;
    }

    public static void setCredits(int credits) {
        SlotMachine.credits = credits;
    }

    public int getWinnerPaid() {
        return winnerPaid;
    }

    public void setWinnerPaid(int winnerPaid) {
        this.winnerPaid = winnerPaid;
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
                ", winnerPaid=(the current round's winnings)= " + winnerPaid +
                ", cashOut=(has user requested to withdraw the coinTray)= " + cashOut +
                '}';
    }
}
