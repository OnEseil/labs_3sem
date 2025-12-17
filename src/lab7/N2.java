package lab7;

public class N2 {

    static class RowMaxThread extends Thread {
        private int[] row;
        private int rowMax;

        public RowMaxThread(int[] row) {
            this.row = row;
        }

        public int getRowMax() {
            return rowMax;
        }

        @Override
        public void run() {
            rowMax = row[0];
            for (int i = 1; i < row.length; i++) {
                if (row[i] > rowMax) {
                    rowMax = row[i];
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int[][] matrix = {
                {5, 2, 9, 4},
                {8, 1, 3, 7},
                {6, 11, 0, 2},
                {4, 13, 5}
        };

        RowMaxThread[] threads = new RowMaxThread[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            threads[i] = new RowMaxThread(matrix[i]);
            threads[i].start();
        }

        for (RowMaxThread thread : threads) {
            thread.join();
        }

        int globalMax = threads[0].getRowMax();
        for (int i = 1; i < threads.length; i++) {
            if (threads[i].getRowMax() > globalMax) {
                globalMax = threads[i].getRowMax();
            }
        }

        System.out.println("Максимальный элемент матрицы: " + globalMax);
    }
}

