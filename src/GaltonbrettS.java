import java.io.FileWriter;
import java.io.IOException;

public class GaltonbrettS {
    private double reihen;
    private double kugeln;
    private int[] faecher;

    public void simulationGaltonbrett(int kugeln, int reihen) {
        this.kugeln = kugeln;
        this.reihen = reihen;
        faecher = new int[reihen +1];
        double position = 0;
        for(int i = 0; i< kugeln;i++){
            position = reihen*0.5;
            for(int r = 0; r < reihen;r++)
            {
              if(Math.random()<0.5){
                  position = position -0.5;
              }else position = position +0.5;
            }faecher[(int) position] = faecher[(int) position] +1;
        }
    }
    public void ausgabeArray()
    {
        try {
            FileWriter writerProzent = new FileWriter("AuswertungProzent.csv");
            FileWriter writerData = new FileWriter("AuswertungsDaten.csv");
            for(int i = 0; i < faecher.length;i++)
            {
                writerData.write(i+1+";"+faecher[i]+"\n");
                writerProzent.write(i+1+";"+faecher[i]/kugeln+"\n");
            }
            writerData.close();
            writerProzent.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for(int i = 0; i < faecher.length;i++)
        {
            System.out.println("im "+(i+1)+" Fach sind "+faecher[i]+" Kugeln gelandet. Daraus ergibt sich folgende Wahrscheinlichkeiten: "+faecher[i]/kugeln);
        }
    }
}
