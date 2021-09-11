package se.iths.java21.Laboration1;

import java.util.Scanner;

//1. Meny
//Börja med att skapa ett program som vid start skriver ut en meny med följande utseende:
//      1. Upp och Ner
//      2. Min Max
//      3. Sten Sax Påse
//      4. Ordning och reda
//      e. Avsluta
//När alternativ e väljs ska programmet avslutas. Både e och E bör vara giltiga som val för att avsluta.
//Vid val av något av de övriga alternativen ska dessa köras och när körningen är klar ska menyn åter
//skrivas ut på skärmen så att ett nytt val kan göras.

public class Main {

    public static void main(String[] args) {
        meny();
    }

    public static void meny() {
        Scanner scanner = new Scanner(System.in);
        UppNer choiceOne = new UppNer();
        MinMax minMax = new MinMax();
        RockPaperScissors rockPaperScissors = new RockPaperScissors();
        OrdingOchReda ordingOchReda = new OrdingOchReda();

        while (true) {
            String selectGame = "";
            System.out.println("1.Upp och Ner");
            System.out.println("2.Min Max");
            System.out.println("3.Sten Sax Påse");
            System.out.println("4.Ordning och reda");
            System.out.println("e.Avsluta");
            System.out.print("Ange ditt val: ");
            selectGame = scanner.nextLine();

            switch (selectGame) {
                case "1" -> {
                    choiceOne.textInput();
                    meny();
                }
                case "2" -> {
                    minMax.valueInput();
                    meny();
                }
                case "3" -> {
                    rockPaperScissors.getGame();
                    meny();
                }
                case "4" -> {
                    ordingOchReda.valueInput();
                    meny();
                }
                case "e", "E" -> System.exit(0);
                default -> {
                    System.out.println("Ogiltigt val");
                    meny();
                }
            }
        }
    }
}
