package org.example;

import java.io.FileNotFoundException;
import java.util.Scanner;

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

        Scanner in = new Scanner(System.in);
        System.out.print("3. feladat: A versenyző azonosítója = ");
        String id = in.nextLine();
        String valaszai = handler.valaszai(id);
        System.out.println(valaszai + "   (a versenyző válasza)\n");

        System.out.println("4. feladat:\n" + handler.getHelyes() + "   (a helyes megoldás)\n" + handler.eltalatakStr(valaszai) + "   (a versenyző helyes válaszai)\n");

        debugger();
    }
}