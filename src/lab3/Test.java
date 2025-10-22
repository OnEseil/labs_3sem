package lab3;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        HashTable<String, Integer> h = new HashTable<>(5);
        System.out.println(h);
        h.put("Aa", 1);
        System.out.println(h);
        h.put("B", 2);
        System.out.println(h);
        h.put("C", 3);
        System.out.println(h);
        h.put("BB", 4);
        System.out.println(h);
        h.put("Aa", 5);
        System.out.println(h);


        HashMap<String, Order> hm = new HashMap<>();
        Order firstOrder = new Order("first", "1 address", 221.2);
        Order secondOrder = new Order("second", "2 address", 345);
        Order thirdOrder = new Order("third", "3 address", 791.68);

        hm.put("Order №19", firstOrder);
        hm.put("Order №65", secondOrder);
        hm.put("Order №73", thirdOrder);
        System.out.println(hm);

        System.out.println(hm.get("Order №73"));
        System.out.println(hm.get("Order №65"));

        hm.remove("Order №65");
        hm.remove("Order №73");
        System.out.println(hm);
    }
}
