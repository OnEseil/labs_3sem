package lab4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CopyFile {
    public static void main(String[] args) {
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("src/lab4/file.txt");
            out = new FileOutputStream("src/lab4/file_copy.txt");

            int byteData;
            while ((byteData = in.read()) != -1) {
                out.write(byteData);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("нет такого фйла");
            e.printStackTrace();
        }
        catch (IOException e) {
            System.out.println("Ошибка ввода или вывода");
            e.printStackTrace();
        }
        finally {
            try {
                if (in != null) in.close();
            } catch (IOException e) {
                System.out.println("Ошибка при закрытии входного файла");
            }

            try {
                if (out != null) out.close();
            } catch (IOException e) {
                System.out.println("Ошибка при закрытии выходного файла");
            }
        }
    }
}