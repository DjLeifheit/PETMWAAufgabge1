import java.util.Scanner;

public class Ausfuehrung {
    private static Scanner scanner = new Scanner(System.in);
    private static int reihen = 11;
    private static int kugeln = 100000;
    private static String variante;
    private static boolean ende = false;
    public static void main(String[] args)
    {
      endlos();
    }
    public static void inversionsMethode()
    {
        Inversionsmethode inversionsmethode = new Inversionsmethode();
        inversionsmethode.aufstellenInversionsmethode(reihen);
        inversionsmethode.kugelnSimulieren(kugeln);
        //inversionsmethode.ausgabeErgebnis();
        inversionsmethode.ausgabeWahrscheinlichkeiten();
    }
    public static void galtonBrettR()
    {
        GaltonbrettBerechnen galtonbrettBerechnen = new GaltonbrettBerechnen();
        galtonbrettBerechnen.berechneGaltonbrett(kugeln,reihen);
        galtonbrettBerechnen.ausgabeArray();
    }
    public static void galtonBrettS(){
        GaltonbrettS galtonbrettS = new GaltonbrettS();
        galtonbrettS.simulationGaltonbrett(kugeln,reihen);
        galtonbrettS.ausgabeArray();
    }
    public static void endlos(){
        while (!ende) {
            System.out.println("\nFalls sie die Inversionsmethode zur Simulation verwenden wollen geben sie 1 ein \n" +
                    "Falls sie die standardmäßige Simulation verwenden wollen geben sie 2 ein \n" +
                    "Falls sie die berechnung verwenden wollen geben sie 3 ein \n" +
                    "Falls sie das Programm beenden wollen geben sie ende ein");
            variante = scanner.next();
            if(variante.equalsIgnoreCase("ende"))
            {
                ende = true;
            }else{
                System.out.println("bitte geben sie die Anzahl der Reihen ein: ");
                reihen = scanner.nextInt();
                System.out.println("bitte geben sie die Anzahl der Kugeln ein: ");
                kugeln = scanner.nextInt();
                int wert = Integer.parseInt(variante);
                switch (wert) {
                    case 1:
                        inversionsMethode();
                        break;
                    case 2:
                        galtonBrettS();
                        break;
                    case 3:
                        galtonBrettR();
                        break;
                    default:
                        System.out.println("ungültige Zahl");
                }
            }
        }


    }
}
