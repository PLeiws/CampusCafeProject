package campusCafee;

import java.math.BigDecimal;

public final class LineItem {
    private final Product product;
    private int quantity;
//	lineItem definition and handling
    public LineItem(Product product, int quantity) {
        if (product == null) throw new IllegalArgumentException("Product cannot be null.");
        setQuantity(quantity);
        this.product = product;
    }

    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) {
        if (quantity <= 0) throw new IllegalArgumentException("Quantity must be > 0.");
        this.quantity = quantity;
    }

    public BigDecimal lineTotal() {
        return product.price().multiply(BigDecimal.valueOf(quantity));
    }
}
