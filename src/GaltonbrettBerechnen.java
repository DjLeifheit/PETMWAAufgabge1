public class GaltonbrettBerechnen {
    private double kugeln;
    private double reihen;
    private double wert;
    private double nueberK;
    private double wahrscheinlichkeit;
    private int reihenK;
    private double[] kammern;
    public void berechneGaltonbrett(int kuglen, int reihen)
    {
        kammern = new double[reihen+1];
        this.kugeln = kuglen;
        this.reihen = reihen;
        for(int k = 0; k< (reihen+1);k++){
            reihenK = reihen - k;
            nueberK = (getFactorial(reihen)/(getFactorial(k)*(getFactorial((reihenK)))));
            wahrscheinlichkeit = 1/Math.pow(2,reihen);
            wert  = kuglen*nueberK*wahrscheinlichkeit;
            kammern[k] =  wert;
        }
    }
    public static int getFactorial(int f) {
        int result = 1;
        for (int i = 1; i <= f; i++) {
            result = result * i; // Ermitteln der Fakultät mit Schleifen
        }
        return result;
    }
    public void ausgabeArray()
    {
        for(int i = 0; i < kammern.length;i++)
        {
            System.out.println("im "+(i+1)+" Fach sind "+kammern[i]+" Kugeln gelandet. Daraus ergibt sich folgende Wahrscheinlichkeit: " +kammern[i]/kugeln);
        }
    }

}
