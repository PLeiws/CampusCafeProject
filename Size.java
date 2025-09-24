package campusCafee;

import java.math.BigDecimal;

public enum Size {
//	Enum to handle size of beverages
    SMALL(BigDecimal.valueOf(1.0)),
    MEDIUM(BigDecimal.valueOf(1.2)),
    LARGE(BigDecimal.valueOf(1.5));

    private final BigDecimal multiplier;

    Size(BigDecimal multiplier) {
        this.multiplier = multiplier;
    }

    public BigDecimal getMultiplier() {
        return multiplier;
    }
}
