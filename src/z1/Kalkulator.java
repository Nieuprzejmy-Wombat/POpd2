package z1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Kalkulator {
    public void oblicz(String plikWejscia, String plikWyjscia) {
        try {
            FileWriter wyjscie = new FileWriter(plikWyjscia);
            try {
                Scanner wejscie = new Scanner(new File(plikWejscia));
                while (wejscie.hasNextInt()) {
                    int operand1 = wejscie.nextInt();
                    String operator = wejscie.next();
                    int operand2 = wejscie.nextInt();
                    switch (operator) {
                        case "+":
                            wyjscie.append((char) (operand1 + operand2));
                            continue;
                        case "-":
                            wyjscie.append((char) (operand1 - operand2));
                            continue;
                        case "*":
                            wyjscie.append((char) (operand1 * operand2));
                            continue;
                        case "/":
                            if (operand2 == 0) {
                                wyjscie.append("dzielenie przez zero");
                                continue;
                            }
                            wyjscie.append((char) (operand1 / operand2));
                    }
                }
                wyjscie.close();
            } catch (FileNotFoundException e) {
                wyjscie.write("Nie znaleziono pliku");
                return;
            }
        } catch (IOException e) {
            System.out.println("an error occurred");
            return;
        }
    }
}
