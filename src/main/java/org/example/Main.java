package org.example;

import java.io.FileNotFoundException;

public class Main {
    private static TesztversenyHandler handler;

    private static void debugger() {
        int i = 0;
    }

    public static void main(String[] args) throws FileNotFoundException {
        handler = new TesztversenyHandler();

        System.out.println("1. feladat: Az adatok beolvasása\n");
        handler.readFile("sourceFiles/valaszok.txt");

        System.out.println("2. feladat: A vetélkedőn " + handler.getValaszokDb() + " versenyző indult.\n");

        debugger();
    }
}