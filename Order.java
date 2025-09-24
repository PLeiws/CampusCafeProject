package campusCafee;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {
	//	stores products that user adds to order
    private final List<LineItem> items = new ArrayList<>();
    //	Handles setting tax rate of seven percent
    private static final BigDecimal TAX_RATE = BigDecimal.valueOf(0.07); 

    public void addItem(Product p, int qty) {
        items.add(new LineItem(p, qty));
    }

    public List<LineItem> getItems() {
        return new ArrayList<>(items); 
    }
//	handles calculating the orders subtotal
    public BigDecimal subtotal() {
        return items.stream()
                .map(LineItem::lineTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    //	Handles calculating tax rate of seven percent
    public BigDecimal tax() {
        return subtotal().multiply(TAX_RATE);
    }
//	handles the calculation of the subtotal and tax combined
    public BigDecimal total() {
        return subtotal().add(tax());
    }
}
