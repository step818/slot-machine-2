package com.casino.games;

import java.util.List;

class SlotMachine {
    // FIELDS
    private int bet = 0;
    private int insertCoin = 0;
    private static int credits = 0;
    private int winnerPaid = 0;
    private boolean cashOut = false;
    private static int coinTray = 0;
    private

    //BUSINESS METHODS
    public List<Reel> spinReel() {
      List<Reel> result = null;

      return result;
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
