package pl.psi.pizza.guifx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;

import java.math.BigDecimal;

import static pl.psi.pizza.guifx.MainController.ingredientsSum;
import static pl.psi.pizza.guifx.MainController.ingredients;

public class IngredientsEntry extends VBox{

    BigDecimal prize;
    CheckBox checkBox;

    public IngredientsEntry(String Text, BigDecimal prize) {
        this.prize = prize;

        checkBox = new CheckBox(Text + " " + prize+ "zł");

        EventHandler<ActionEvent> event = e -> {
            if (checkBox.isSelected()){
                ingredientsSum = ingredientsSum.add(prize);
                ingredients += (Text + " ");
            }
            else {
                ingredientsSum = ingredientsSum.subtract(prize);
                ingredients = ingredients.replace((Text + " "),"");
            }
        };

        checkBox.setOnAction(event);
        getChildren().add(checkBox);
    }
}
