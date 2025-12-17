package lab7;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    static class Worker extends Thread {
        Warehouse warehouse;
        String name;

        Worker(Warehouse w, String name) {
            warehouse = w;
            this.name = name;
        }

        @Override
        public void run() {
            while (warehouse.hasGoods()) {
                List<Integer> items = warehouse.takeGoods();
                if (!items.isEmpty()) {
                    int totalWeight = items.stream().mapToInt(Integer::intValue).sum();
                    System.out.println(name + " взял товары: " + items + " (общий вес: " + totalWeight + ")");
                }
                try {
                    Thread.sleep(100); // небольшая пауза для наглядности
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(name + " завершил работу");
        }
    }

    static class Warehouse {
        Queue<Integer> goods;
        ReentrantLock lock = new ReentrantLock();
        int MAX_LOAD = 150;
        int totalProcessed = 0; // счетчик обработанных товаров

        Warehouse(List<Integer> initialGoods) {
            goods = new LinkedList<>(initialGoods);
            System.out.println("На складе товары: " + initialGoods);
        }

        List<Integer> takeGoods() {
            lock.lock();
            try {
                List<Integer> taken = new ArrayList<>();
                int load = 0;
                while (!goods.isEmpty() && load + goods.peek() <= MAX_LOAD) {
                    int w = goods.poll();
                    taken.add(w);
                    load += w;
                    totalProcessed++;
                }
                return taken;
            } finally {
                lock.unlock();
            }
        }

        boolean hasGoods() {
            lock.lock();
            try {
                return !goods.isEmpty();
            } finally {
                lock.unlock();
            }
        }

        int getTotalProcessed() {
            return totalProcessed;
        }
    }

    public static void main(String[] args) {
        List<Integer> initialGoods = Arrays.asList(50, 70, 30, 90, 40, 60, 20, 10, 80);
        System.out.println("Начало работы склада");
        System.out.println("Максимальная нагрузка за один раз: " + 150);

        Warehouse warehouse = new Warehouse(initialGoods);

        Worker worker1 = new Worker(warehouse, "Работник 1");
        Worker worker2 = new Worker(warehouse, "Работник 2");
        Worker worker3 = new Worker(warehouse, "Работник 3");

        worker1.start();
        worker2.start();
        worker3.start();

        // Ждем завершения всех работников
        try {
            worker1.join();
            worker2.join();
            worker3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nВсе работники завершили работу");
        System.out.println("Всего обработано товаров: " + warehouse.getTotalProcessed());
    }
}