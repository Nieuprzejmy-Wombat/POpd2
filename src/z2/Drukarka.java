package z2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Drukarka {
    private Queue<Integer> kolejka;

    public Drukarka(){
        kolejka = new PriorityQueue<Integer>(Comparator.reverseOrder());
    }
    public void start(String plikWejscia, String plikWyjscia) {
        try {
            PrintWriter wyjscie = new PrintWriter(plikWyjscia);
            try {
                Scanner wejscie = new Scanner(new File(plikWejscia));
                while (wejscie.hasNextLine()){
                    String obecnaLinijka = wejscie.nextLine();
                    switch (obecnaLinijka) {
                        case "drukuj":
                            if (kolejka.isEmpty()) {
                                wyjscie.println("brak");
                            } else {
                                wyjscie.println(kolejka.poll());
                            }
                            continue;
                        case "koniec":
                            Integer glowa = kolejka.poll();
                            while (glowa != null ) {
                                wyjscie.println(glowa);
                                glowa = kolejka.poll();
                            }
                            break;
                        default:
                            kolejka.add(Integer.parseInt(obecnaLinijka));
                    }
                }
                wyjscie.close();
            } catch (FileNotFoundException e) {
                wyjscie.println("Nie znaleziono pliku");
                wyjscie.close();
            }
        } catch (IOException e) {
            System.out.println("błąd");
        }
    }
}
