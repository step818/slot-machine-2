package com.casino.client;
import com.casino.games.SlotMachine;

class Player {
    public static void main(String[] args) throws InterruptedException {
        SlotMachine machine = new SlotMachine();
        machine.begin();
    }
}