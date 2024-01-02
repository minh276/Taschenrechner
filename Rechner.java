import java.io.*;

public class Rechner {
    private char operator;
    private double zahl1;
    private double zahl2;
    private double ergebnis;

    // Einlesen des Operators und der Zahlen
    public void einlesen() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.print("Wähle ein Operatorenzeichen mit den du rechnen willst (+, -, *, /): ");
            operator = reader.readLine().charAt(0);

            System.out.print("Gebe eine beliebe Zahl ein die berechnet werden soll: ");
            zahl1 = Double.parseDouble(reader.readLine());

            System.out.print("Gebe eine weitere beliebe Zahl ein die berechnet werden soll: ");
            zahl2 = Double.parseDouble(reader.readLine());
			
        } catch (IOException | NumberFormatException e) {
            System.out.println("Fehler beim Einlesen: " + e.getMessage());
        }
    
}

    //  Berechnen des Ergebnisses
    public boolean berechne() {
        switch (operator) {
            case '+':
                ergebnis = zahl1 + zahl2;
                break;
            case '-':
                ergebnis = zahl1 - zahl2;
                break;
            case '*':
                ergebnis = zahl1 * zahl2;
                break;
            case '/':
                // Überprüfe, ob der Divisor nicht null ist
                if (zahl2 != 0) {
                    ergebnis = zahl1 / zahl2;
                } else {
                    System.out.println("Fehler: Division durch Null ist nicht erlaubt.");
                    return false; // Fehlerfall
                }
                break;
            default:
                System.out.println("Ungültiger Operator.");
                return false; // Fehlerfall
        }

        return true; // Alles ok
    }

    // Ausgeben des Ergebnisses
    public void ausgeben() {
        System.out.println("Ergebnis: " + ergebnis);
    }

     public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Rechner rechner = new Rechner();
        char weiter;

        do {
            rechner.einlesen();

            if (rechner.berechne()) {
                rechner.ausgeben();
            }

            System.out.print("Weiter? (n für Beenden): ");
            try {
                weiter = reader.readLine().charAt(0);
            } catch (IOException e) {
                System.out.println("Fehler beim Lesen der Eingabe: " + e.getMessage());
                weiter = 'n';  // Im Fehlerfall Beenden
            }

        } while (weiter != 'n');
    }
}
    


