package pl.psi.pizza.model;

import java.math.BigDecimal;
import java.util.ArrayList;

public class PizzaPie {
    private String name;
    private ArrayList<String> ingredients;
    private String pan;
    private BigDecimal price;

    public PizzaPie(String name, ArrayList<String> ingredients, String pan, BigDecimal price) {
        this.name = name;
        this.ingredients = ingredients;
        this.pan = pan;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
