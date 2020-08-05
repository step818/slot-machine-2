package com.casino.games;

import java.util.Collection;
import java.util.Map;

class Reel extends SlotMachine {
    // VARIABLES
    private int slotNumber1 = (int) (Math.random() * 100); // 'slotNumber1', 'slotNumber2', and 'slotNumber3' hold the value of the generated numbers upon runtime.
    private int slotNumber2 = (int) (Math.random() * 100); // These variables are generated using Java Math's 'random()' method. By default, the 'random()' method
    private int slotNumber3 = (int) (Math.random() * 100); // is calculated via double. '(int)' is used to cast the double back into an int.

    private Symbol symbol1; // 'symbol1', 'symbol2', and 'symbol3' store the appropriate keyboard icon from the Symbol enum
    private Symbol symbol2; // when ran through the if statement (found within the 'assignSymbol' method).
    private Symbol symbol3;

    // BUSINESS METHODS
    public Symbol assignSymbol1() { // This method takes a randomly generated number and assigns an Enum symbol to it.
        if (slotNumber1 >=0 && slotNumber1 <= 15) {
            this.symbol1 = Symbol.AT;
        }
        else if (slotNumber1 >= 16 && slotNumber1 <= 30) {
            this.symbol1 = Symbol.HASH;
        }
        else if (slotNumber1 >= 31 && slotNumber1 <= 42) {
            this.symbol1 = Symbol.COLON;
        }
        else if (slotNumber1 >= 43 && slotNumber1 <= 54) {
            this.symbol1 = Symbol.QUESTION;
        }
        else if (slotNumber1 >= 55 && slotNumber1 <= 65) {
            this.symbol1 = Symbol.PERCENT;
        }
        else if (slotNumber1 >= 66 && slotNumber1 <= 75) {
            this.symbol1 = Symbol.AMPERSAND;
        }
        else if (slotNumber1 >= 76 && slotNumber1 <= 84) {
            this.symbol1 = Symbol.BANG;
        }
        else if (slotNumber1 >= 85 && slotNumber1 <= 92) {
            this.symbol1 = Symbol.SEVEN;
        }
        else if (slotNumber1 >= 93 && slotNumber1 <= 99) {
            this.symbol1 = Symbol.GOLD;
        }
        else if (slotNumber1 == 100) {
            this.symbol1 = Symbol.DOLLAR;
        }
        return symbol1;
    }

    public Symbol assignSymbol2() { // This method takes a randomly generated number and assigns an Enum symbol to it.

        if (slotNumber2 >=0 && slotNumber2 <= 15) {
            this.symbol2 = Symbol.AT;
        }
        else if (slotNumber2 >= 16 && slotNumber2 <= 30) {
            this.symbol2 = Symbol.HASH;
        }
        else if (slotNumber2 >= 31 && slotNumber2 <= 42) {
            this.symbol2 = Symbol.COLON;
        }
        else if (slotNumber2 >= 43 && slotNumber2 <= 54) {
            this.symbol2 = Symbol.QUESTION;
        }
        else if (slotNumber2 >= 55 && slotNumber2 <= 65) {
            this.symbol2 = Symbol.PERCENT;
        }
        else if (slotNumber2 >= 66 && slotNumber2 <= 75) {
            this.symbol2 = Symbol.AMPERSAND;
        }
        else if (slotNumber2 >= 76 && slotNumber2 <= 84) {
            this.symbol2 = Symbol.BANG;
        }
        else if (slotNumber2 >= 85 && slotNumber2 <= 92) {
            this.symbol2 = Symbol.SEVEN;
        }
        else if (slotNumber2 >= 93 && slotNumber2 <= 99) {
            this.symbol2 = Symbol.GOLD;
        }
        else if (slotNumber2 == 100) {
            this.symbol2 = Symbol.DOLLAR;
        }
        return symbol2;
    }

    public Symbol assignSymbol3() { // This method takes a randomly generated number and assigns an Enum symbol to it.

        if (slotNumber3 >=0 && slotNumber3 <= 15) {
            this.symbol3 = Symbol.AT;
        }
        else if (slotNumber3 >= 16 && slotNumber3 <= 30) {
            this.symbol3 = Symbol.HASH;
        }
        else if (slotNumber3 >= 31 && slotNumber3 <= 42) {
            this.symbol3 = Symbol.COLON;
        }
        else if (slotNumber3 >= 43 && slotNumber3 <= 54) {
            this.symbol3 = Symbol.QUESTION;
        }
        else if (slotNumber3 >= 55 && slotNumber3 <= 65) {
            this.symbol3 = Symbol.PERCENT;
        }
        else if (slotNumber3 >= 66 && slotNumber3 <= 75) {
            this.symbol3 = Symbol.AMPERSAND;
        }
        else if (slotNumber3 >= 76 && slotNumber3 <= 84) {
            this.symbol3 = Symbol.BANG;
        }
        else if (slotNumber3 >= 85 && slotNumber3 <= 92) {
            this.symbol3 = Symbol.SEVEN;
        }
        else if (slotNumber3 >= 93 && slotNumber3 <= 99) {
            this.symbol3 = Symbol.GOLD;
        }
        else if (slotNumber3 == 100) {
            this.symbol3 = Symbol.DOLLAR;
        }
        return symbol3;
    }

    // GETTER METHODS
    public int getSlotNumber1() { // Provides access to 'slotNumber1'.
        return slotNumber1;
    }

    public int getSlotNumber2() { // Provides access to 'slotNumber2'.
        return slotNumber2;
    }

    public int getSlotNumber3() { // Provides access to 'slotNumber3'.
        return slotNumber3;
    }

    public Symbol getSymbol1() { // Provides access to 'getSymbol1'.
        return symbol1;
    }

    public Symbol getSymbol2() { // Provides access to 'getSymbol2'.
        return symbol2;
    }

    public Symbol getSymbol3() { // Provides access to 'getSymbol3'.
        return symbol3;
    }

//    // FIELDS
//    private Symbol symbol;
//    //
//    private Map<Symbol, Integer> mappedSymbols;
//
//    // CONSTRUCTORS
//
//    //BUSINESS METHODS
//    public void getRandom() {
////        int rand = (int)(Math.random() * 100);
////        switch(rand) {
////            case 0: case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9:
////                setSymbol(Symbol.AT);
////                break;
////            case 10: case 11: case 12: case 13: case 14: case 15: case 16: case 17: case 18: case 19: case 20:
////                setSymbol(Symbol.HASH);
////
////            default:
////                setSymbol(Symbol.AT);
////        }
//        setSymbol(Symbol.AMPERSAND);
//    }
//
//    public Symbol getSymbol() {
//        return symbol;
//    }
//
//    public void setSymbol(Symbol symbol) {
//        this.symbol = symbol;
//    }
//
//    public Map<Symbol, Integer> getMappedSymbols() {
//        return mappedSymbols;
//    }
//
//    public void setMappedSymbols(Map<Symbol, Integer> mappedSymbols) {
//        this.mappedSymbols = mappedSymbols;
//    }
}