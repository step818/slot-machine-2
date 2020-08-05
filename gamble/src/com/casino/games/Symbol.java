package com.casino.games;

public enum Symbol {
    AT("@"),
    HASH("#"),
    DOLLAR("$"),
    PERCENT("%"),
    COLON(":"),
    AMPERSAND("&"),
    QUESTION("?"),
    BANG("!"),
    GOLD("G"),
    SEVEN("7");

    private String charAssignment;

    Symbol(String charAssignment) {
        this.charAssignment = charAssignment;
    }

    public String toString() {
        return this.charAssignment;
    }
}

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