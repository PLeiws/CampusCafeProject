package campusCafee;

import java.math.BigDecimal;

public class Beverage extends Product {
    private Size size;

    public Beverage(String id, String name, BigDecimal basePrice, Size size) {
        super(id, name, basePrice);
        setSize(size);
    }

    public Size getSize() { return size; }

    public void setSize(Size size) {
        if (size == null) throw new IllegalArgumentException("Size cannot be null.");
        this.size = size;
    }

    
    public BigDecimal price() {
        return getBasePrice().multiply(size.getMultiplier());
    }

    public String getDisplayName() {
        return super.getDisplayName() + " (" + size.name() + ")";
    }
}
