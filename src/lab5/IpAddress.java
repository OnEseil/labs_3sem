package lab5;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IpAddress {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("^((25[0-5]|2[0-4]\\d|1?\\d\\d?)\\.){3}(25[0-5]|2[0-4]\\d|1?\\d\\d?)$");
        Matcher matcher = pattern.matcher(scanner.nextLine());
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
