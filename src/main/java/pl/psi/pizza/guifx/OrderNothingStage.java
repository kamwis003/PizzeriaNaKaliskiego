package pl.psi.pizza.guifx;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.math.BigDecimal;

public class OrderNothingStage {

    public OrderNothingStage(){
        Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.setTitle("Info");
        dialogStage.setWidth(220);

        Button button = new Button("OK");
        button.setOnAction(arg0 -> dialogStage.close());

        VBox vbox = new VBox(new Text("Nic nie wybrałeś!\nNajpierw wybierz pizze!\n"), button);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(15));

        dialogStage.setScene(new Scene(vbox));
        dialogStage.show();
    }
}