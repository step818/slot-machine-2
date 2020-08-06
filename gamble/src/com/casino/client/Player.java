package com.casino.client;
import com.casino.games.SlotMachine;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

class Player {
    public static void main(String[] args) throws InterruptedException {
        //  Prints the banner
        try (BufferedReader reader = new BufferedReader(
                new FileReader("banner.txt"))) {
            Stream<String> lines = reader.lines();
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Create an instance of the slot machine
        SlotMachine machine = new SlotMachine();
        System.out.println("Welcome to the Slot Machine! You have "+ "\u001B[32m"+ machine.getCredits() + "\u001B[0m" + " credits.");
        machine.getPayoutChart();
        // Start the game
        machine.begin();
    }
}