package models;

import java.util.List;

public class User {
    private List<Order> orders;
    private String dni;

    public User(String dni) {
        this.dni = dni;
        orders = new ArrayList<>();
    }   

    public void addOrder(Order order) {
         orders.add(order);
    }
    public List<Order> orders() {
        return orders;
    }
}
