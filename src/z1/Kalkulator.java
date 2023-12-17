package z1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;

public class Kalkulator {
    public void oblicz(String plikWejscia, String plikWyjscia) {
        try {
            PrintWriter wyjscie = new PrintWriter(plikWyjscia);
            try {
                Scanner wejscie = new Scanner(new File(plikWejscia));
                while (wejscie.hasNextInt()) {
                    int operand1 = wejscie.nextInt();
                    String operator = wejscie.next();
                    int operand2 = wejscie.nextInt();
                    switch (operator) {
                        case "+":
                            wyjscie.println(operand1 + operand2);
                            continue;
                        case "-":
                            wyjscie.println(operand1 - operand2);
                            continue;
                        case "*":
                            wyjscie.println(operand1 * operand2);
                            continue;
                        case "/":
                            if (operand2 == 0) {
                                wyjscie.println("dzielenie przez zero");
                                continue;
                            }
                            wyjscie.println(operand1 / operand2);
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
