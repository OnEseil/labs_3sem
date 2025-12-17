package lab5;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindLowerCaseAfterUpper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        Pattern pattern = Pattern.compile("[a-z][A-Z]");
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()){
            System.out.print(matcher.group() + " ");
        }
        System.out.println();
        String result = text.replaceAll(pattern.pattern(), "!$0!");
        System.out.println(result);
    }
}
