package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class TesztversenyHandler {
    private String helyes;
    private String[][] valaszok;
    private int valaszokDb;

    public String getHelyes() {
        return helyes;
    }

    public void setHelyes(String helyes) {
        this.helyes = helyes;
    }

    public String[][] getValaszok() {
        return valaszok;
    }

    public void setValaszok(String[][] valaszok) {
        this.valaszok = valaszok;
    }

    public int getValaszokDb() {
        return valaszokDb;
    }

    public void setValaszokDb(int valaszokDb) {
        this.valaszokDb = valaszokDb;
    }

    private void debugger() {
        int i = 0;
    }

    public TesztversenyHandler() {
        valaszok = new String[500][];
    }

    public TesztversenyHandler readFile(String filename) throws FileNotFoundException {
        // implement readFile with BufferedReader
        File file = new File(filename);
        Scanner scanner = new Scanner(file);

        setHelyes(scanner.nextLine()); // 1. sorban a helyes válaszok
        setValaszokDb(0);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] split = line.split(" ");

            valaszok[getValaszokDb()] = new String[3];
            valaszok[getValaszokDb()][0] = split[0];
            valaszok[getValaszokDb()][1] = split[1];

            setValaszokDb(getValaszokDb() + 1);
        }
        debugger();
        return this;
    }

    public String valaszai(String azon) {

        for (int i = 0; i < getValaszokDb(); i++) {

            if (Objects.equals(valaszok[i][0], azon)) {
                return valaszok[i][1];
            }
        }
        return null;
    }

    public String eltalatakStr(String tippek) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < tippek.length(); i++) {
            if (tippek.charAt(i) == getHelyes().charAt(i)) {
                result.append("+");
            } else {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public double[] helyesFeladatStat(int feladatSorszam) {
        double[] result = new double[2];
        for (int i = 0; i < getValaszokDb(); i++) {
            if (eltalatakStr(valaszok[i][1]).charAt(feladatSorszam - 1) == '+') {
                result[0]++;
            }
        }

        result[1] = result[0] / getValaszokDb() * 100;
        return result;
    }

    public void calculatePoints() {

        for (int i = 0; i < getValaszokDb(); i++) {
            String eltalaltaStr = eltalatakStr(valaszok[i][1]);
            Integer sum = 0;
            for (int j = 0; j < eltalaltaStr.length(); j++) {
                if (eltalaltaStr.charAt(j) == '+') {
                    switch (j) {
                        case 1-1, 2-1, 3-1, 4-1, 5-1: {
                            sum += 3;
                            break;
                        }
                        case 6-1,7-1,8-1,9-1,10-1: {
                            sum += 4;
                            break;
                        }
                        case 11-1, 12-1, 13-1: {
                            sum += 5;
                            break;
                        }
                        case 14-1: {
                            sum += 6;
                            break;
                        }
                    }
                }
            }
            valaszok[i][2] = sum.toString();
        }
    }

    public void pointsToFile(String filename) throws IOException {
        File fki = new File(filename);
        FileWriter fwki = new FileWriter(fki);
        for (int i = 0; i < getValaszokDb(); i++) {
            fwki.write(valaszok[i][0] + ";" + valaszok[i][2] + "\n");
        }
        fwki.close();
    }

    public Set<Integer> pointsSet() {
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < getValaszokDb(); i++) {
            result.add(Integer.parseInt(valaszok[i][2]));
        }
        return result;
    }

    public void printWinners (int points1, int points2, int points3) {
        for (int i = 0; i < getValaszokDb(); i++) {
            if (Integer.parseInt(valaszok[i][2]) == points1) {
                System.out.println("1. díj (" + points1 + " pont): " + valaszok[i][0]);
            }


        }
    }
}
