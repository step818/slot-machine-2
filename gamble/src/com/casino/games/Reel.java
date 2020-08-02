package com.casino.games;

import java.util.Collection;
import java.util.Map;

class Reel extends SlotMachine {
    // FIELDS
    private Symbol symbol;
    private Map<Symbol, Character> mappedSymbols;

    // CONSTRUCTORS

    //BUSINESS METHODS
    public void getRandom() {

        this.symbol = Symbol.AMPERSAND;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public Map<Symbol, Character> getMappedSymbols() {
        return mappedSymbols;
    }

    public void setMappedSymbols(Map<Symbol, Character> mappedSymbols) {
        this.mappedSymbols = mappedSymbols;
    }
}