import models.Order;
import models.Product;
import models.User;

import java.util.*;

public class ProductManagerImpl implements ProductManager {
    private List<Product> productList;
    private Queue<Order> orderQueue;
    private HashMap<String, User> users;


    public ProductManagerImpl() {
        users = new HashMap<>();
        productList = new ArrayList<>();
        orderQueue = new LinkedList<>();
    }

    @Override
    public void addProduct(String id, String name, double price) {
        productList.add(new Product(id, name, price));

    }

    @Override
    public List<Product> getProductsByPrice() {
        productList.sort(Comparator.comparingDouble(Product::getPrice));
        return productList;
    }

    @Override
    public void addOrder(Order order) {
        orderQueue.add(order);

    }

    @Override
    public int numOrders() {
        return orderQueue.size();
    }

    @Override
    public Order deliverOrder() {
        Order order = orderQueue.poll();
        // DONE
        if (order != null) {
            // 1. Gestiona l'usuari i afegeix la comanda al seu historial
            String dni = order.getUser();
            // getOrDefault evita errors si l'usuari es nou
            User user = users.getOrDefault(dni, new User());
            user.addOrder(order);
            users.put(dni, user);

            // 2. Actualitza les vendes dels productes de la comanda
            for (Order.LP item : order.getItems()) {
                Product p = getProduct(item.getProductId());
                if (p != null) {
                    p.addSales(item.getQuantity());
                }
            }
        }
        return order;
    }

    @Override
    public Product getProduct(String c1) {

        Product p = null;
        for (p : productList) {
            if (p.getId().equals(c1)) {
                return p;
            }
        }
        if(p == null) {
            throw new IllegalArgumentException("Product not found: " + c1);
            return null;
        }
    }

    @Override
    public User getUser(String number) {
        return users.get(number);
    }
}
