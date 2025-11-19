package lab4;

import java.util.Scanner;

public class ArrayAverage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");
        double sum = 0;
        try {
            for (int i = 0; i < arr.length; i++) {
                sum += Double.parseDouble(arr[i]);
            }
            System.out.println(sum / arr.length);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("индекс вышел за размеры массива");
            } catch (IllegalArgumentException e) {
            System.out.println("элемент не является числом");
        }
    }
}
