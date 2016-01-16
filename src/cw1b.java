
import java.io.*;

public class cw1b {

    public static void main(String[] args) {
        try {
            FileReader plikWe = new FileReader("plik.txt");
            int c;
            int licznik=1;
            while ((c = plikWe.read()) != -1) {
                System.out.print((char) c);
                if(c==13||c==32||c==9){
                licznik++;
                }
            }
            System.out.println("\n"+licznik);
        } catch (Exception e) {
        };

    }

}