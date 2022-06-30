package pl.psi.pizza.guifx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FxMain extends Application {

    public FxMain() {
    }

    static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/main.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("Pizzeria u Ledzia");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException aE) {
            aE.printStackTrace();
        }
    }
}