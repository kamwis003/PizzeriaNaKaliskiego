package pl.psi.pizza.menu;

import pl.psi.pizza.model.Ingredient;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class IngredientsMenu {
    public List<Ingredient> getIngredientsList() {
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("papryka", new BigDecimal("0.80")));
        ingredients.add(new Ingredient("czosnek", new BigDecimal("0.90")));
        ingredients.add(new Ingredient("pieczarki", new BigDecimal("1.10")));
        ingredients.add(new Ingredient("ananas", new BigDecimal("1.40")));
        ingredients.add(new Ingredient("mozzarella", new BigDecimal("1.50")));
        ingredients.add(new Ingredient("salami pikantne", new BigDecimal("1.60")));
        ingredients.add(new Ingredient("karczochy", new BigDecimal("1.70")));
        ingredients.add(new Ingredient("kukurydza", new BigDecimal("1.90")));
        ingredients.add(new Ingredient("sos pomidorowy", new BigDecimal("2.00")));
        ingredients.add(new Ingredient("bekon", new BigDecimal("2.10")));
        ingredients.add(new Ingredient("szynka", new BigDecimal("2.20")));
        ingredients.add(new Ingredient("sos czosnkowy", new BigDecimal("2.50")));
        ingredients.add(new Ingredient("oliwa z oliwek", new BigDecimal("3.00")));
        ingredients.add(new Ingredient("czarne oliwki", new BigDecimal("3.20")));

        return ingredients;
    }
}
