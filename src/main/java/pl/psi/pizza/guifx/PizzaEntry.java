package pl.psi.pizza.guifx;

import javafx.scene.control.RadioButton;
import javafx.scene.layout.HBox;

import java.math.BigDecimal;

import static pl.psi.pizza.guifx.MainController.pizzaGroup;
import static pl.psi.pizza.guifx.MainController.isCheckedPizza;

public class PizzaEntry extends HBox{

    BigDecimal prize;

    public PizzaEntry(String aText, BigDecimal prize) {
        this.prize = prize;

        RadioButton button = new RadioButton(aText + " " + prize+ "zł");
        button.setToggleGroup(pizzaGroup);
        if(!isCheckedPizza){
            button.setSelected(true);
            isCheckedPizza = true;
        }
        getChildren().add(button);
    }

}
