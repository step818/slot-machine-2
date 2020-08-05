package com.casino.games;

/* The Reel class contains the random number generator used to provide symbols and payout to the player.
 * The Java Math class will be utilized within Reel for its valuable 'random()' method.
 */

class Reel extends SlotMachine { //

    // 'slotNumber' holds the value of the generated number upon runtime.
    // This variable is generated using Java Math's 'random()' method. By default, the 'random()' method is calculated via double.
    // '(int)' is used to cast the double back into an int.
    private int slotNumber = (int) (Math.random() * 100);

    // 'symbol' stores the appropriate keyboard icon from the Symbol enum when ran through the if statement (found within the 'assignSymbol' method).
    private Symbol symbol;

    // This method takes a randomly generated number and assigns an Enum symbol to it.
    public Symbol assignSymbol() {

        /* STATISTICS (possibility of hitting each symbol, and the payout to the player). This is going least payout to greatest payout.
         * Follow this format: Symbol name --> keyboard symbol --> range --> hit statistic (%) --> payout for two hits --> payout for three hits.
         * AT        --> @ --> 0-15  --> 16%  --> 100%  --> 200%
         * HASH      --> # --> 16-30 --> 15%  --> 110%  --> 210%
         * COLON     --> : --> 31-42 --> 12%  --> 150%  --> 250%
         * QUESTION  --> ? --> 43-54 --> 12%  --> 150%  --> 250%
         * PERCENT   --> % --> 55-65 --> 11%  --> 160%  --> 260%
         * AMPERSAND --> & --> 66-75 --> 10%  --> 170%  --> 270%
         * BANG      --> ! --> 76-84 --> 9%   --> 180%  --> 280%
         * SEVEN     --> 7 --> 85-92 --> 8%   --> 190%  --> 290%
         * GOLD      --> G --> 93-99 --> 7%   --> 200%  --> 300%
         * DOLLAR    --> $ --> 100   --> 1%   --> 5000% --> 10000%
         */

        if (getSlotNumber() >= 0 && getSlotNumber() <= 15) {
            this.symbol = Symbol.AT;
        } else if (getSlotNumber() >= 16 && getSlotNumber() <= 30) {
            this.symbol = Symbol.HASH;
        } else if (getSlotNumber() >= 31 && getSlotNumber() <= 42) {
            this.symbol = Symbol.COLON;
        } else if (getSlotNumber() >= 43 && getSlotNumber() <= 54) {
            this.symbol = Symbol.QUESTION;
        } else if (getSlotNumber() >= 55 && getSlotNumber() <= 65) {
            this.symbol = Symbol.PERCENT;
        } else if (getSlotNumber() >= 66 && getSlotNumber() <= 75) {
            this.symbol = Symbol.AMPERSAND;
        } else if (getSlotNumber() >= 76 && getSlotNumber() <= 84) {
            this.symbol = Symbol.BANG;
        } else if (getSlotNumber() >= 85 && getSlotNumber() <= 92) {
            this.symbol = Symbol.SEVEN;
        } else if (getSlotNumber() >= 93 && getSlotNumber() <= 99) {
            this.symbol = Symbol.GOLD;
        } else if (getSlotNumber() == 100) {
            this.symbol = Symbol.DOLLAR;
        }
        return symbol;
    }

    // ADMIN METHOD (GOD MODE)
    public Symbol easyJackpot() { // Used to show a guaranteed jackpot during presentation.
        final int winningNumber = 100;
        if (winningNumber == 100) {
            this.symbol = Symbol.DOLLAR;
        }
        return symbol;
    }

    // GETTER METHODS
    public int getSlotNumber() { // Provides access to 'slotNumber'.
        return this.slotNumber;
    }

    public Symbol getSymbol() { // Provides access to 'getSymbol'.
        return this.symbol;
    }
}

////    // FIELDS
////    private Symbol symbol;
////    //
////    private Map<Symbol, Integer> mappedSymbols;
////
////    // CONSTRUCTORS
////
////    //BUSINESS METHODS
////    public void getRandom() {
//////        int rand = (int)(Math.random() * 100);
//////        switch(rand) {
//////            case 0: case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9:
//////                setSymbol(Symbol.AT);
//////                break;
//////            case 10: case 11: case 12: case 13: case 14: case 15: case 16: case 17: case 18: case 19: case 20:
//////                setSymbol(Symbol.HASH);
//////
//////            default:
//////                setSymbol(Symbol.AT);
//////        }
////        setSymbol(Symbol.AMPERSAND);
////    }
////
////    public Symbol getSymbol() {
////        return symbol;
////    }
////
////    public void setSymbol(Symbol symbol) {
////        this.symbol = symbol;
////    }
////
////    public Map<Symbol, Integer> getMappedSymbols() {
////        return mappedSymbols;
////    }
////
////    public void setMappedSymbols(Map<Symbol, Integer> mappedSymbols) {
////        this.mappedSymbols = mappedSymbols;
////    }
//}