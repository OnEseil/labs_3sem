package lab6;

import java.util.LinkedHashMap;
import java.util.Map;

import java.util.*;

import java.util.*;

public class SalesManager {
    private LinkedHashMap<String, ProductInfo> sales = new LinkedHashMap<>();

    public void addProduct(String name, double price) {
        if (sales.containsKey(name)) {
            sales.get(name).increment();
        } else {
            sales.put(name, new ProductInfo(price));
        }
    }

    public void printSales() {
        for (var e : sales.entrySet()) {
            System.out.println(e.getKey() + " — " + e.getValue().count);
        }
    }

    public double getTotalSum() {
        double sum = 0;
        for (var e : sales.entrySet()) {
            sum += e.getValue().count * e.getValue().price;
        }
        return sum;
    }

    public String getMostPopular() {
        return sales.entrySet().stream()
                .max(Comparator.comparingInt(a -> a.getValue().count))
                .map(Map.Entry::getKey)
                .orElse("Нет данных");
    }

    public static void main(String[] args) {
        SalesManager sm = new SalesManager();
        sm.addProduct("Хлеб", 1.2);
        sm.addProduct("Молоко", 1.5);
        sm.addProduct("Хлеб", 1.2);

        sm.printSales();
        System.out.println("Сумма продаж: " + sm.getTotalSum());
        System.out.println("Самый популярный товар: " + sm.getMostPopular());
    }


    class ProductInfo {
        double price;
        int count;

        ProductInfo(double price) {
            this.price = price;
            this.count = 1;
        }

        void increment() {
            count++;
        }
    }
}
