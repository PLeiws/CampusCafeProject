package campusCafee;

import java.math.BigDecimal;

public abstract class Product {
    private String id;
    private String name;
    private BigDecimal basePrice;

    public Product(String id, String name, BigDecimal basePrice) {
        setId(id);
        setName(name);
        setBasePrice(basePrice);
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public BigDecimal getBasePrice() { return basePrice; }

    public final void setId(String id) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("ID cannot be blank.");
        this.id = id;
    }

    public final void setName(String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name cannot be blank.");
        this.name = name;
    }

    public final void setBasePrice(BigDecimal basePrice) {
        if (basePrice == null || basePrice.compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("Base price must be >= 0.");
        this.basePrice = basePrice;
    }

    public String getDisplayName() {
        return id + " - " + name;
    }

    public abstract BigDecimal price();
}

