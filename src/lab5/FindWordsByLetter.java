package lab5;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindWordsByLetter {
    public static void main(String[] args) {
        System.out.println("Текст: ");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        System.out.println("Буква:");
        String word = scanner.nextLine();
        Pattern pattern = Pattern.compile("\\b" +  word + "\\w*");
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
