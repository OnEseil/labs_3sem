package lab7;

public class N1 {

    static class SumThread extends Thread {
        private int[] array;
        private int start;
        private int end;
        private long partialSum = 0;

        public SumThread(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        public long getPartialSum() {
            return partialSum;
        }

        @Override
        public void run() {
            for (int i = start; i < end; i++) {
                partialSum += array[i];
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        int mid = arr.length / 2;

        SumThread t1 = new SumThread(arr, 0, mid);
        SumThread t2 = new SumThread(arr, mid, arr.length);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        long total = t1.getPartialSum() + t2.getPartialSum();

        System.out.println("Сумма элементов массива: " + total);
    }
}
