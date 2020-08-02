package com.casino.games;

import org.junit.jupiter.api.Test;

import java.util.Collection;

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
        Collection<Reel> result = game.spinReel();
        assertNotNull(result);
        assertEquals(3, result.size());
        for(Reel reel : result) {
            assertEquals(Symbol.AMPERSAND, reel.getSymbol());
        }
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        System.out.println("After");
    }
}