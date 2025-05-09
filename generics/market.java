interface Category {
    String getCategoryName();
}

enum BookCategory implements Category {
    FICTION, NONFICTION, EDUCATION;

    public String getCategoryName() {
        return this.name();
    }
}

enum ClothingCategory implements Category {
    MEN, WOMEN, CHILDREN;

    public String getCategoryName() {
        return this.name();
    }
}

enum GadgetCategory implements Category {
    MOBILE, LAPTOP, ACCESSORY;

    public String getCategoryName() {
        return this.name();
    }
}
class Product<T extends Category> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public void applyDiscount(double percentage) {
        this.price -= this.price * (percentage / 100);
    }

    public void display() {
        System.out.println("Product: " + name + ", Category: " + category.getCategoryName() + ", Price: $" + price);
    }

    public double getPrice() {
        return price;
    }

    public T getCategory() {
        return category;
    }
}
class DiscountUtil {
    public static <T extends Category> void applyDiscount(Product<T> product, double percentage) {
        product.applyDiscount(percentage);
        System.out.println("Discount applied. New price: $" + product.getPrice());
    }
}
public class market {
    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("The Great Gatsby", 30.0, BookCategory.FICTION);
        Product<ClothingCategory> shirt = new Product<>("T-Shirt", 20.0, ClothingCategory.MEN);
        Product<GadgetCategory> phone = new Product<>("Smartphone", 500.0, GadgetCategory.MOBILE);

        book.display();
        shirt.display();
        phone.display();

        DiscountUtil.applyDiscount(book, 10); // 10% off
        DiscountUtil.applyDiscount(shirt, 15); // 15% off
        DiscountUtil.applyDiscount(phone, 5); // 5% off
    }
}
