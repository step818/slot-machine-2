package com.casino.games;

/* STATISTICS (possibility of hitting each symbol, and the payout to the player). This is going least payout to greatest payout.
 * Follow this format: Symbol name --> keyboard symbol --> range --> hit statistic (%) --> payout for two hits --> payout for three hits.
 * AT        --> @ --> 0-15  --> 16%  --> bet*2*2  --> bet*3*2
 * HASH      --> # --> 16-30 --> 15%  --> bet*2*3  --> bet*3*3
 * COLON     --> : --> 31-42 --> 12%  --> bet*2*4  --> bet*3*4
 * QUESTION  --> ? --> 43-54 --> 12%  --> bet*2*4  --> bet*3*4
 * PERCENT   --> % --> 55-65 --> 11%  --> bet*2*5  --> bet*3*5
 * AMPERSAND --> & --> 66-75 --> 10%  --> bet*2*6  --> bet*3*6
 * BANG      --> ! --> 76-84 --> 9%   --> bet*2*7  --> bet*3*7
 * SEVEN     --> 7 --> 85-92 --> 8%   --> bet*2*8  --> bet*3*8
 * GOLD      --> G --> 93-99 --> 7%   --> bet*2*9  --> bet*3*9
 * DOLLAR    --> $ --> 100   --> 1%   --> bet*2*50 --> bet*3*300
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