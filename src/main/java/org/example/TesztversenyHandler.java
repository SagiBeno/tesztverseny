package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TesztversenyHandler {
    private String helyes;
    private String[][] valaszok;

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

    private void debugger() {
        int i = 0;
    }

    public TesztversenyHandler readFile(String filename) throws FileNotFoundException {
        // implement readFile with BufferedReader
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            debugger();
        }

        return this;
    }
}
