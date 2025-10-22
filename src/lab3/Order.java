package lab3;

public class Order {
    private String info;

    private String deliveryAddress;

    private double price;

    public Order(String info, String deliveryAddress, double price) {
        this.info = info;
        this.deliveryAddress = deliveryAddress;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Order{" +
                "info='" + info + '\'' +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", price=" + price +
                "}";
    }
}
