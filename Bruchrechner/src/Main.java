import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean weiter = true;

        while (weiter) {
            try {
                System.out.println("Ersten Bruch eingeben:");
                Bruchzahl bruch1 = bruchEinlesen(scanner);

                System.out.println("Zweiten Bruch eingeben:");
                Bruchzahl bruch2 = bruchEinlesen(scanner);

                System.out.println("Welche Rechenoperation möchtest du durchführen?");
                System.out.println("+  Addieren");
                System.out.println("-  Subtrahieren");
                System.out.println("*  Multiplizieren");
                System.out.println("/  Dividieren");
                System.out.print("Auswahl: ");

                String operation = scanner.next();

                Bruchzahl ergebnis;

                switch (operation) {
                    case "+":
                        ergebnis = bruch1.addieren(bruch2);
                        break;

                    case "-":
                        ergebnis = bruch1.subtrahieren(bruch2);
                        break;

                    case "*":
                        ergebnis = bruch1.multiplizieren(bruch2);
                        break;

                    case "/":
                        ergebnis = bruch1.dividieren(bruch2);
                        break;

                    default:
                        System.out.println("Ungültige Rechenoperation.");
                        continue;
                }

                System.out.println();
                System.out.println("Ergebnis:");
                System.out.println(bruch1 + " " + operation + " " + bruch2 + " = " + ergebnis);

            } catch (Exception e) {
                System.out.println("Fehler: " + e.getMessage());
            }

            System.out.println();
            System.out.print("Möchtest du noch einmal rechnen? (j/n): ");
            String antwort = scanner.next();

            if (!antwort.equalsIgnoreCase("j")) {
                weiter = false;
            }

            System.out.println();
        }

        System.out.println("Programm beendet.");
        scanner.close();
    }

    public static Bruchzahl bruchEinlesen(Scanner scanner) {
        System.out.print("Zähler: ");
        int zaehler = scanner.nextInt();

        System.out.print("Nenner: ");
        int nenner = scanner.nextInt();

        return new Bruchzahl(zaehler, nenner);
    }
}