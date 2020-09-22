import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("(?:Yes\\b|Ja\\b|[yj1]|[yj1].+)", Pattern.CASE_INSENSITIVE);

        Scanner in = new Scanner(System.in);

        System.out.println("Indtast beløb:");
        double inputTotal = in.nextDouble();

        System.out.println("Tilføj drikkepenge?");
        String tipAnswer = in.next();

        final Matcher matcher = pattern.matcher(tipAnswer);

        if (matcher.matches()){
            System.out.println("Drikkepenge:");
            int tip = in.nextInt();
            new Receipt(inputTotal,tip);
        }
        else{
            new Receipt(inputTotal);
        }
    }
}
