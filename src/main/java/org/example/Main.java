package org.example;

public class Main {
    private static TesztversenyHandler handler;

    private static void debugger() {
        int i = 0;
    }

    public static void main(String[] args) {
        handler = new TesztversenyHandler();

        System.out.println("1. feladat: Az adatok beolvasása");
        handler.readFile("valaszok.txt");
        debugger();
    }
}