package org.example;

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

    public TesztversenyHandler readFile(String filename) {
        // TODO - implement readFile
        return this;
    }
}
