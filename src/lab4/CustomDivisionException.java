package lab4;

import java.io.FileWriter;
import java.io.IOException;

public class CustomDivisionException extends Exception {
    public CustomDivisionException() {
    }

    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter("log.txt");
        try {
            System.out.println(Division(1, 0));
            fileWriter.append("1 / 0 логировано!\n");
        } catch (CustomDivisionException e) {
            System.out.println("b is null");
            fileWriter.append("1 / 0 не логировано!\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println(Division(2, 1));
            fileWriter.append("2 / 1 логировано!\n");
        } catch (CustomDivisionException e) {
            System.out.println("b isn't null");
            fileWriter.append("2 / 1 не логировано!\n");
        }
        fileWriter.close();
    }

    public static int Division(int a, int b) throws CustomDivisionException {
        if (b != 0) return a / b;
        throw new CustomDivisionException();
    }
}
