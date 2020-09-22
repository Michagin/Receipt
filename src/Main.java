import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("(?:[yjYJ1])+");

        Scanner in = new Scanner(System.in);

        System.out.println("Indtast beløb:");
        double inputTotal = in.nextDouble();

        System.out.println("Tilføj drikkepenge?");
        String tipAsnwer = in.next();

        final Matcher matcher = pattern.matcher(tipAsnwer);

        if (matcher.matches()){
            System.out.println("Drikkepenge:");
            int tip = in.nextInt();
            Receipt receipt = new Receipt(inputTotal,tip);
        }
        else{
            Receipt receipt = new Receipt(inputTotal,0);
        }
    }
}