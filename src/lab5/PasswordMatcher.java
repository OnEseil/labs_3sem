package lab5;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordMatcher {
    public static void main(String[] args) {
        while(true){
            Scanner scanner = new Scanner(System.in);
            String password = scanner.nextLine();
            Pattern pattern1 = Pattern.compile("[A-Z]");
            Pattern pattern2 = Pattern.compile("^[A-Za-z0-9]{8,16}$");
            Pattern pattern3 = Pattern.compile("[0-9]");
            Matcher matcher1 = pattern1.matcher(password);
            Matcher matcher2 = pattern2.matcher(password);
            Matcher matcher3 = pattern3.matcher(password);

            if (matcher2.find() && matcher1.find() && matcher3.find()) {
                System.out.println("Пароль корректен");
            } else {
                System.out.println("Пароль не корректен");
            }
        }
    }
}
