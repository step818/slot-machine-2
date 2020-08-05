package com.casino.games;

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

public enum Symbol { // Each Enum value is assigned to a special character that will display on the console window when the Reel class is utilized.
    AT("@"),
    HASH("#"),
    COLON(":"),
    QUESTION("?"),
    PERCENT("%"),
    AMPERSAND("&"),
    BANG("!"),
    SEVEN("7"),
    GOLD("G"),
    DOLLAR("$");

    private String charAssignment; // Variable to hold the assigned character.

    Symbol(String charAssignment) { // The enum method that passes in 'charAssignment' and assigns it.
        this.charAssignment = charAssignment;
    }

    public String toString() { // This method converts 'charAssignment' to a String (such as @, #, :, etc.) and returns it.
        return this.charAssignment;
    }

}