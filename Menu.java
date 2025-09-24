package campusCafee;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final List<Product> baseProducts = new ArrayList<>();

    public Menu() {
        // Base templates (no size/add-on chosen yet)
        baseProducts.add(new Beverage("B1", "Coffee", BigDecimal.valueOf(2.50), Size.SMALL));
        baseProducts.add(new Beverage("B2", "Tea", BigDecimal.valueOf(2.00), Size.SMALL));
        baseProducts.add(new Beverage("B3", "Latte", BigDecimal.valueOf(3.00), Size.SMALL));

        baseProducts.add(new Food("F1", "Sandwich", BigDecimal.valueOf(5.00), false));
        baseProducts.add(new Food("F2", "Pizza Slice", BigDecimal.valueOf(3.50), false));
    }

    public List<Product> getProducts() {
        return new ArrayList<>(baseProducts);
    }

    public void display() {
        System.out.println("=== MENU ===");
        for (int i = 0; i < baseProducts.size(); i++) {
            Product p = baseProducts.get(i);
            System.out.printf("%d) %s (base price $%.2f)%n", 
                              i + 1, p.getName(), p.getBasePrice());
        }
    }
}
