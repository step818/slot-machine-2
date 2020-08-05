package com.casino.client;
import com.casino.games.SlotMachine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

class Player {
    public static void main(String[] args) throws InterruptedException {
        try (BufferedReader reader = new BufferedReader(
                new FileReader("banner.txt"))) {
            Stream<String> lines = reader.lines();
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        SlotMachine machine = new SlotMachine();
        machine.begin();
    }
}