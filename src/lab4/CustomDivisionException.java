package lab4;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class CustomDivisionException extends ArithmeticException {
                                                                                                                                                                                                            public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter("src/lab4/log.txt", true);
        try {
            System.out.println(Division(1, 0));
        } catch (CustomDivisionException e) {
            System.out.println("b is null");
            fileWriter.append(Arrays.toString(e.getStackTrace()) + "\n");
        }

        try {
            System.out.println(Division(2, 1));
        } catch (CustomDivisionException e) {
            System.out.println("b isn't null");
            fileWriter.append(Arrays.toString(e.getStackTrace()) + "\n");
        }
        fileWriter.close();
    }

    public static int Division(int a, int b) throws CustomDivisionException {
        try {
            return a /b;
        }catch(ArithmeticException e){
            throw new CustomDivisionException();
        }
    }
}
