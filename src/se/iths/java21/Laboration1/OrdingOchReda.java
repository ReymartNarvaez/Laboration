package se.iths.java21.Laboration1;

import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 5. Ordning och reda
//Använd samma inläsning för tal som i uppgift 3 men modifiera den om nödvändigt så att du kan läsa
//in alla tal som en textrad där talen separeras av mellanslag istället för radbrytning.
//Utöka även så att programmet nu hittar det näst största respektive näst minsta talet samt addera
//ihop talen och presentera summan.
//Programmet ska även kontrollera om talen står i ordning så att inget mindre tal följer på ett större. I
//exemplet nedan så är -2 mindre än 10 och talordningen är därmed inte i ordning.
//Exempel på inläsning
//1 2 10 -2 100
//Min value: -2
//2Min value: 1
//Max value: 100
//2Max value: 10
//I ordning: false
//Summa: 111

public class OrdingOchReda {
    Scanner scanner = new Scanner(System.in);

    public void valueInput() {
        ArrayList<Integer> numberList = new ArrayList<>();
        System.out.print("Skriv in 5 heltal: ");
        for (int i = 0; i < 5; i++) {
            int value = scanner.nextInt();
            numberList.add(value);
        }
        int largest = Collections.max(numberList);
        int least = Collections.min(numberList);
        int size = numberList.size();
        List copyNumberList = new ArrayList(numberList);
        Collections.sort(numberList);
        boolean sortedOrNot = copyNumberList.equals(numberList);
        int nextLargest = numberList.get(size - 2);
        Collections.reverse(numberList);
        int nextLeast = numberList.get(size - 2);
        int sum = 0;
        for (int i = 0; i < numberList.size(); i++) {
            sum += numberList.get(i);
        }
        System.out.println("Max value: " + largest);
        System.out.println("2Max value: " + nextLargest);
        System.out.println("Min value: " + least);
        System.out.println("2Min value: " + nextLeast);
        System.out.println("In order: " + sortedOrNot);
        System.out.println("Summa: " + sum);
    }
}

