package se.iths.java21.Laboration1;
import java.util.*;
//4. Sten Sax Påse
//Här ska man kunna spela sten sax påse mot datorn. Låt användaren mata in sitt val på något lämpligt
//sätt och slumpa sedan datorns val. Först till 3 vinster vinner. Mellan varje omgång ska du skriva ut
//vem som vann omgången eller om det blev oavgjort samt poängställningen just nu.
//När någon vunnit 3 gånger ska ett gratulationsmeddelande skrivas ut riktat mot vinnaren.

public class RockPaperScissors {
    Scanner scanner = new Scanner(System.in);
    String input;
    String yourChoice;
    int computerPoints;
    int userPoints;
    int RandomChoice;
    String computerChoice;

    void userChoice() {
        System.out.println("1.Sten");
        System.out.println("2.Sax");
        System.out.println("3.Påse");
        System.out.print("Ange ditt val: ");
        input = scanner.nextLine();
        switch (input) {
            case "1", "sten", "Sten","STEN" -> this.yourChoice = "sten";
            case "2", "sax", "Sax","SAX" -> this.yourChoice = "sax";
            case "3", "påse", "Påse","PÅSE" -> this.yourChoice = "påse";
            default -> {
                System.out.println("Ogiltligt svar");
                userChoice();
            }
        }
    }

    void computerRandomChoice(){
        RandomChoice = (int) ((Math.random() * 3) + 1);
        if(RandomChoice == 1)
            computerChoice = "sten";
        else if (RandomChoice == 2)
            computerChoice = "sax";
        else if (RandomChoice == 3)
            computerChoice = "påse";
    }

    void commentsUserWins(){
        System.out.println("Datorn valde " + computerChoice);
        System.out.println("Du valde " + yourChoice);
        ++userPoints;
        System.out.println("Du vann omgången!");
        System.out.println("Datorns poäng: " + computerPoints);
        System.out.println("Dina poäng: " + userPoints);
    }

    void commentsComputerWins(){
        System.out.println("Datorn valde " + computerChoice);
        System.out.println("Du valde " + yourChoice);
        ++computerPoints;
        System.out.println("Datorn vann omgången!");
        System.out.println("Datorns poäng: " + computerPoints);
        System.out.println("Dina poäng: " + userPoints);
    }

    void commentsDraw(){
        System.out.println("Datorn valde " + computerChoice);
        System.out.println("Du valde " + yourChoice);
        System.out.println("Oavgjort!");
        System.out.println("Datorns poäng: " + computerPoints);
        System.out.println("Dina poäng: " + userPoints);
    }
    void computerRock() {
        switch (yourChoice) {
            case "sten" -> commentsDraw();
            case "sax" -> commentsComputerWins();
            case "påse" -> commentsUserWins();
        }
    }

    void computerScissor() {
        switch (yourChoice) {
            case "sten" -> commentsUserWins();
            case "sax" -> commentsDraw();
            case "påse" -> commentsComputerWins();
        }
    }

    void computerPaper() {
        switch (yourChoice) {
            case "sten" -> commentsComputerWins();
            case "sax" -> commentsUserWins();
            case "påse" -> commentsDraw();

        }
    }

    void getGame() {
        System.out.println("Först till 3 vinster vinner!");
        while (computerPoints < 3 && userPoints < 3) {
            computerRandomChoice();
            userChoice();
            switch (computerChoice) {
                case "sten" -> computerRock();
                case "sax" -> computerScissor();
                case "påse" -> computerPaper();
            }
        }
        if (userPoints == 3)
            System.out.println("Gattis! Du Har Vunnit!");
        else if (computerPoints == 3)
            System.out.println("Du Förlorade! Datorn Vann!");
    }
}