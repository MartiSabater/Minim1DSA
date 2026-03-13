package models;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String user;
    private List<LP> items;


    public Order(String dni) {
        this.user = dni;
        items = new ArrayList<>();
    }

    public void addLP(int i, String s) {
        items.add(new LP(i, s));
    }

    public String getUser() {
        return user;
    }
    public List<LP> getItems() {
        return items;
    }

    public static class LP {
        private String productId;
        private int quantity;

        public LP(int quantity, String productId) {
            this.quantity = quantity;
            this.productId = productId;
        }

        public String getProductId() {
            return productId;
        }

        public int getQuantity() {
            return quantity;
        }
    }
}
