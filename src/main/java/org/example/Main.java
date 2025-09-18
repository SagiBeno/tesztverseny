package org.example;

import java.io.IOException;
import java.util.*;

public class Main {
    public static boolean isRunningTest = false;

    private static final String testAzon = "AB123";
    private static final int testFeladatSorszam = 10;

    private static TesztversenyHandler handler;

    private static void debugger() {
        int i = 0;
    }

    public static void main(String[] args) throws IOException {
        handler = new TesztversenyHandler();

        System.out.println("1. feladat: Az adatok beolvasása\n");
        handler.readFile("sourceFiles/valaszok.txt");

        System.out.println("2. feladat: A vetélkedőn " + handler.getValaszokDb() + " versenyző indult.\n");

        Scanner in = new Scanner(System.in);
        System.out.print("3. feladat: A versenyző azonosítója = ");
        String id = isRunningTest ? testAzon : in.nextLine();
        String valaszai = handler.valaszai(id);
        System.out.println(valaszai + "   (a versenyző válasza)\n");

        System.out.println("4. feladat:\n" + handler.getHelyes() + "   (a helyes megoldás)\n" + handler.eltalatakStr(valaszai) + "   (a versenyző helyes válaszai)\n");

        System.out.print("5. feladat: A feladat sorszáma = ");
        int feladatSorszam = isRunningTest ? testFeladatSorszam : in.nextInt();
        double[] helyesFeladatStat = handler.helyesFeladatStat(feladatSorszam);
        //System.out.println("A feladatra " + (int)helyesFeladatStat[0] + " fő, a versenyzők " + Math.round(helyesFeladatStat[1] * 100.0) /100.0 + " %-a adott helyes választ.\n");
        System.out.println("A feladatra " + String.format("%.0f", helyesFeladatStat[0]) + " fő, a versenyzők " + String.format("%.2f", helyesFeladatStat[1]) + " %-a adott helyes választ.\n");

        System.out.println("6. feladat: A versenyzők pontszámának meghatározása\n");
        handler.calculatePoints();
        handler.pointsToFile("pontok.txt");

        Set<Integer> pointSet = handler.pointsSet();
        List<Integer> pointsList = new ArrayList<>(pointSet);
        pointsList.sort((e1, e2) -> e2-e1);
        System.out.println("7. feladat: A verseny legjobbjai:");
        handler.printWinners(pointsList.get(0), pointsList.get(1), pointsList.get(2));

        debugger();
    }
}