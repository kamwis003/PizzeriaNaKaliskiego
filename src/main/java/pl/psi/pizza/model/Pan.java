package pl.psi.pizza.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Pan {
    private String name;
    private BigDecimal price;

    public Pan(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Pans{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pan pans = (Pan) o;
        return Objects.equals(name, pans.name) &&
                Objects.equals(price, pans.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
