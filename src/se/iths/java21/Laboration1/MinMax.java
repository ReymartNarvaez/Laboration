package se.iths.java21.Laboration1;
import java.util.*;

//Alternativet Min Max ska fungera ungefär som uppgift 2 men nu ska vi istället läsa in 5 heltal och när
//inläsningen är klar ska vi skriva ut det minsta och det största talet av de inlästa. Även negativa tal ska
//kunna hanteras. Uppgiften kan lösas antingen med hjälp av en array som lagrar talen som läses in
//eller så lagrar man bara det hittills största och minsta talet i två variabler. (En lösning som använder
//5 variabler är inte godkänd.)
//Exempel på inläsningen
//1
//2
//10
//-2
//100
//Min value: -2
//Max value: 100

public class MinMax {
    Scanner scanner = new Scanner(System.in);

    public void valueInput() {
        System.out.println("Skriv in 5 heltal: ");
        ArrayList<Integer> number = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++) {
            int value = scanner.nextInt();
            number.add(value);
        }
        int largest = Collections.max(number);
        int least = Collections.min(number);
        System.out.println("Max value: " + largest);
        System.out.println("Min value: " + least);

    }


}




