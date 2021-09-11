package se.iths.java21.Laboration1;
import java.util.*;

// När man väljer alternativ ett ska programmet läsa in ett antal textsträngar från standard input.
//Inläsningen avbryts genom att skriva END som sträng. När inläsningen är klar ska strängarna skrivas
//ut i omvänd ordning enligt exempel. Du kan antingen implementera ett max antal strängar man kan
//mata in eller implementera det hela utan gräns vilket är lite svårare att lösa.
//one
//two
//three
//END
//three
//two
//one

public class UppNer {
    Scanner scanner = new Scanner(System.in);

    public void textInput() {
        int count = 0;
        String textString = "";
        ArrayList<String> textStringList = new ArrayList<String>();
        System.out.println("Skriv in textsträngar och avbryts genom att skriva END: ");
        for (int i = count; true; count++) {
            textString = scanner.nextLine();
            if (textString.equals("END")) {
                Collections.reverse(textStringList);
                textStringList.forEach(System.out::println);
                break;
            }
            textStringList.add(textString);
        }
    }
}