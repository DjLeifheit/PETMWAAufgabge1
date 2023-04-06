import java.util.Scanner;

public class Inversionsmethode {
    private int kugeln;
    private int reihen;
    private double[] wertI;
    private int[] anzahlKugeln;
    private double wert;
    private double nueberK;
    private double wahrscheinlichkeit;
    private double pfade;
    private double pfadF;
    private int reihenK;

    public void aufstellenInversionsmethode(int anzahlReihen) {
        this.reihen = anzahlReihen;
        wertI = new double[reihen + 1];
        pfade = getFactorial(reihen);
        wahrscheinlichkeit = 1/Math.pow(2,reihen);
        for (int k = 0; k < (reihen + 1); k++) {
            reihenK = reihen - k;
            double faktK = getFactorial(k);
            double faktR = getFactorial(reihenK);
            pfadF =faktK * faktR;
            nueberK = (pfade / pfadF);
            wert =wert+ nueberK * wahrscheinlichkeit;
            wertI[k] = wert;
        }
    }

    public void kugelnSimulieren(int kugeln) {
        anzahlKugeln = new int[reihen + 1];
        double random;
        this.kugeln = kugeln;
        for (int i = 0; i < kugeln; i++) {
            random = Math.random();
            for (int k = 0; k < wertI.length; k++) {
                if (random >= wertI[k]) {

                } else {
                    anzahlKugeln[k] = anzahlKugeln[k] + 1;
                    break;
                }
            }
        }
    }

    public static int getFactorial(int f) {
        int result = 1;
        for (int i = 1; i <= f; i++) {
            result = result * i; // Ermitteln der Fakultät mit Schleifen
        }
        return result;
    }

    public void ausgabeErgebnis() {
        for (int i = 0; i < anzahlKugeln.length; i++) {
            System.out.println("im " + (i + 1) + " Fach sind " + anzahlKugeln[i] + " Kugeln gelandet");
        }
    }
    public void ausgabeWahrscheinlichkeiten() {
        for (int i = 0; i < wertI.length; i++) {
            System.out.println("der mindest Zufallswert im " + (i + 1) + " Fach beträgt "+ wertI[i]);
        }
    }
}
