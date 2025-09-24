package campusCafee;

import java.math.BigDecimal;

public class Food extends Product {
    private boolean extraCheese;

    public Food(String id, String name, BigDecimal basePrice, boolean extraCheese) {
        super(id, name, basePrice);
        this.extraCheese = extraCheese;
    }

    public boolean hasExtraCheese() { return extraCheese; }

    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }

   
    public BigDecimal price() {
        BigDecimal price = getBasePrice();
        if (extraCheese) {
            price = price.add(BigDecimal.valueOf(1.00)); 
            // surcharge handling
        }
        return price;
    }

  
    public String getDisplayName() {
        return super.getDisplayName() + (extraCheese ? " + Extra Cheese" : "");
    }
}

