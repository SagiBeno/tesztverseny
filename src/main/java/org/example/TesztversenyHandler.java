package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

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
            valaszok[getValaszokDb()] = split;

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
        return null; // TODO
    }

    public String eltalatakStr(String tippek) {
        // TODO
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
}
