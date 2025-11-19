package lab4;

public class ArrayAverage {
    public static void main(String[] args) {
        String[] arr = {"1", "2", "3", "4", "5"};
        double sum = 0;
        try {
            for (int i = 0; i < arr.length ; i++) {
                sum += Double.parseDouble(arr[i]);
            }
            System.out.println(sum / arr.length);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("индекс вышел за размеры массива");
            throw new ArrayIndexOutOfBoundsException(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("элемент не является числом");
            throw new IndexOutOfBoundsException(e.getMessage());
        }
    }
}
