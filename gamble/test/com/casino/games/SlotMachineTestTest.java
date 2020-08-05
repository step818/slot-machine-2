package com.casino.games;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SlotMachineTestTest {
    SlotMachine game;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        game = new SlotMachine();
        System.out.println("Before");
    }

    @Test
    void testSpinReel() {
        ArrayList<Symbol> result = game.spinReel(6);
        assertNotNull(result);
        assertEquals(3, result.size());
//        for(Reel reel : result) {
//            assertEquals(Symbol.AMPERSAND, reel.getSymbol());
//        }
    }

    @Test
    void testCheckWinnings() {
        ArrayList<Symbol> display = new ArrayList<>();
        display.add(Symbol.AT);
        display.add(Symbol.AT);
        display.add(Symbol.AT);

        int result = game.checkWinnings(display);
        assertEquals(50, result);
    }

//    @Test
//    void testSymbolIsString() {
//        ArrayList<Symbol> display = new ArrayList<>();
//        display.add(Symbol.DOLLAR);
//        display.add(Symbol.AMPERSAND);
//        Symbol sym = new Symbol("$");
//
//        assertEquals(, display.get(0));
//    }

    @Test
    void testIsValidBet() {
        boolean result = game.isValidBet(20);
        assertTrue(result);
    }



    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        System.out.println("After");
    }
}