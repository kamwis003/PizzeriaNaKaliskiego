package pl.psi.pizza.menu;

import pl.psi.pizza.model.Ingredient;
import pl.psi.pizza.model.Pan;
import pl.psi.pizza.model.PizzaPie;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PizzaPieMenu {

    public List<PizzaPie> getItalianPizzasList() {
        String pan = "cienkie";
        return makePizzasList(pan);
    }

    public List<PizzaPie> getAmericanPizzasList(){
        String pan = "grube";
        return makePizzasList(pan);
    }

    private ArrayList<PizzaPie> makePizzasList(String pan){
        BigDecimal zero = new BigDecimal("0.0");
        ArrayList<PizzaPie> pizzas = new ArrayList<>();
        pizzas.add(new PizzaPie("MARGERITTA", new ArrayList<>(Arrays.asList("sos pomidorowy, mozzarella".split(", "))), pan, zero));
        pizzas.add(new PizzaPie("MARINARA", new ArrayList<>(Arrays.asList("sos pomidorowy, mozzarella, czosnek".split(", "))), pan, zero));
        pizzas.add(new PizzaPie("NAPOLETANA", new ArrayList<>(Arrays.asList("sos pomidorowy, mozzarella, czarne oliwki".split(", "))), pan, zero));
        pizzas.add(new PizzaPie("HAWAJSKA", new ArrayList<>(Arrays.asList("sos pomidorowy, mozzarella, ananas".split(", "))), pan, zero));
        pizzas.add(new PizzaPie("FUNGHI", new ArrayList<>(Arrays.asList("sos pomidorowy, mozzarella, pieczarki".split(", "))), pan, zero));
        pizzas.add(new PizzaPie("QUATRO STAGIONI", new ArrayList<>(Arrays.asList("sos pomidorowy, mozzarella, szynka, karczochy, papryka".split(", "))), pan, zero));
        pizzas.add(new PizzaPie("CAPRICCIOSA", new ArrayList<>(Arrays.asList("sos pomidorowy, mozzarella, szynka, pieczarki".split(", "))), pan, zero));
        pizzas.add(new PizzaPie("DINAMITE", new ArrayList<>(Arrays.asList("sos pomidorowy, mozzarella, salami pikantne".split(", "))), pan, zero));

        //counting prize
        IngredientsMenu ingredientsMenu = new IngredientsMenu();
        PansMenu pansMenu = new PansMenu();

        for(PizzaPie p: pizzas){
            for(String s: p.getIngredients()) {
                for(Ingredient i : ingredientsMenu.getIngredientsList()) {
                    if(s.equals(i.getName())) p.setPrice(p.getPrice().add(i.getPrice()));
                }
            }
            for(Pan q: pansMenu.getPansMenu()){
                if(p.getPan().equals(q.getName())) p.setPrice(p.getPrice().add(q.getPrice()));
            }
        }
        return pizzas;
    }
}
