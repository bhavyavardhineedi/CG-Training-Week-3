import java.util.*;

class ShoppingCart {
    private Map<String, Double> productPrices = new HashMap<>(); // HashMap to store product prices
    private LinkedHashMap<String, Double> cartItems = new LinkedHashMap<>(); // LinkedHashMap to maintain insertion order
    private TreeMap<Double, List<String>> sortedByPrice = new TreeMap<>(); // TreeMap to store products sorted by price

    // Add a product to the cart
    public void addProduct(String product, double price) {
        // Store product price in HashMap
        productPrices.put(product, price);
        
        // Add product to cart with its price in LinkedHashMap (insertion order maintained)
        cartItems.put(product, price);
        
        // Add product to TreeMap sorted by price
        sortedByPrice.putIfAbsent(price, new ArrayList<>());
        sortedByPrice.get(price).add(product);
    }

    // Remove a product from the cart
    public void removeProduct(String product) {
        if (cartItems.containsKey(product)) {
            double price = cartItems.get(product);
            cartItems.remove(product);
            
            // Remove product from TreeMap by price
            sortedByPrice.get(price).remove(product);
            if (sortedByPrice.get(price).isEmpty()) {
                sortedByPrice.remove(price);
            }
        }
    }

    // Get the total price of the products in the cart
    public double getTotalPrice() {
        double total = 0;
        for (double price : cartItems.values()) {
            total += price;
        }
        return total;
    }

    // Display all items in the cart in the order they were added (LinkedHashMap)
    public void displayCartItemsInOrder() {
        System.out.println("Items in cart (Insertion Order):");
        for (Map.Entry<String, Double> entry : cartItems.entrySet()) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
        }
    }

    // Display all items sorted by their prices (TreeMap)
    public void displayItemsSortedByPrice() {
        System.out.println("\nItems sorted by price:");
        for (Map.Entry<Double, List<String>> entry : sortedByPrice.entrySet()) {
            for (String product : entry.getValue()) {
                System.out.println(product + ": $" + entry.getKey());
            }
        }
    }

    // Display the total price of items in the cart
    public void displayTotalPrice() {
        System.out.println("\nTotal price of items in cart: $" + getTotalPrice());
    }
}

public class ShoppingCartDemo {

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Adding products to the cart
        cart.addProduct("Laptop", 799.99);
        cart.addProduct("Smartphone", 599.49);
        cart.addProduct("Headphones", 149.99);
        cart.addProduct("Keyboard", 89.99);
        cart.addProduct("Mouse", 29.99);

        // Displaying the cart
        cart.displayCartItemsInOrder();
        cart.displayItemsSortedByPrice();
        cart.displayTotalPrice();

        // Remove a product and display the updated cart
        cart.removeProduct("Smartphone");
        System.out.println("\nAfter removing Smartphone:");
        cart.displayCartItemsInOrder();
        cart.displayItemsSortedByPrice();
        cart.displayTotalPrice();
    }
}
