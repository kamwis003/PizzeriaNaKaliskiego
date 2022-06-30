package pl.psi.pizza.guifx;

import javafx.scene.control.RadioButton;
import javafx.scene.layout.VBox;

import java.math.BigDecimal;

import static pl.psi.pizza.guifx.MainController.deliveryGroup;
import static pl.psi.pizza.guifx.MainController.isCheckedDelivery;

public class DeliveryEntry extends VBox {
    BigDecimal prize;

    public DeliveryEntry(String aText, BigDecimal prize) {
        this.prize = prize;

        RadioButton button = new RadioButton(aText + " " + prize + "zł");
        button.setToggleGroup(deliveryGroup);
        if (!isCheckedDelivery) {
            button.setSelected(true);
            isCheckedDelivery = true;
        }
        getChildren().add(button);
    }
}
