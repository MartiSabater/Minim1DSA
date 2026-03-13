package models;

public class Product {

    private  String id;
    private  String name;
    private double price;
    private int sales  = 0;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int sales() {
        return this.sales;
    }

    public double getPrice() {
        return price;
    }
    public void addSales(int quantity) {
        sales += quantity;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}
