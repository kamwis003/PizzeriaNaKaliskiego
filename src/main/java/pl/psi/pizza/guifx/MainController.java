package pl.psi.pizza.guifx;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import pl.psi.pizza.menu.DeliveryOptions;
import pl.psi.pizza.menu.IngredientsMenu;
import pl.psi.pizza.menu.PizzaPieMenu;
import pl.psi.pizza.model.Delivery;
import pl.psi.pizza.model.Ingredient;
import pl.psi.pizza.model.PizzaPie;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainController {

    public static BigDecimal totalSum;
    public static ToggleGroup deliveryGroup;
    public static ToggleGroup pizzaGroup;
    public static Boolean isCheckedPizza;
    public static Boolean isCheckedDelivery;
    public static String ingredients;
    public static BigDecimal ingredientsSum;
    private BigDecimal prevDiscount;
    private BigDecimal prevDelivery;
    private Integer num;
    private TextArea textArea;

    @FXML
    private ScrollPane scrollPaneBox;
    @FXML
    private VBox pizzaBox;
    @FXML
    private VBox ingredientsBox;
    @FXML
    private VBox deliveryOptionsBox;
    @FXML
    private Label orderPriceLabel;
    @FXML
    private Label totalPrice;
    @FXML
    private ToggleGroup pieGroup;
    @FXML
    private Button addPizzaButton;
    @FXML
    private ToggleGroup discountGroup;
    @FXML
    private Label infoDiscount;


    @FXML
    private void initialize() {
        totalSum = BigDecimal.ZERO;
        prevDelivery = BigDecimal.ZERO;
        prevDiscount = BigDecimal.ZERO;
        pizzaGroup = new ToggleGroup();
        deliveryGroup = new ToggleGroup();
        num = 1;
        ingredients = "";
        ingredientsSum = new BigDecimal("0.0");
        textArea = new TextArea();
        textArea.setEditable(false);
        textArea.setPrefWidth(291);

        addPizzaButton.setText("DODAJ DO\n ZAMÓWIENIA");
        addPizzaButton.textAlignmentProperty().set(TextAlignment.CENTER);

        orderPriceLabel.setText("Witaj, wybierz to na co masz ochote! ");
        orderPriceLabel.setPadding(new Insets(10, 10, 10, 20));
        pieGroup.selectedToggleProperty().addListener( (e) -> refreshPizzaMenu());
        discountGroup.selectedToggleProperty().addListener( (e)-> checkStudentDiscount());
        deliveryGroup.selectedToggleProperty().addListener((e -> addDeliveryCost()));

        ingredientsMenu();
        refreshPizzaMenu();
        deliveryOptions();
    }

    @FXML
    private void confirmOrderAction(){
        if(textArea.getText().equals("")){
            new OrderNothingStage();
        }
        else {
            new OrderPizzaStage(totalSum);
        }
        clearScrollPaneBox();
    }

    @FXML
    private void setTotalPrize(){
        totalPrice.setText(totalSum + "zł");
    }

    //reset order
    @FXML
    private void clearScrollPaneBox(){
        textArea.setText("");
        totalSum = BigDecimal.ZERO;
        prevDelivery = BigDecimal.ZERO;
        prevDiscount = BigDecimal.ZERO;
        num = 1;
        checkStudentDiscount();
    }

    @FXML
    private void addPizzaButtonAction(){
        String selectedRadioButton = ((RadioButton) pizzaGroup.getSelectedToggle()).getText();

        Pattern patternPrice = Pattern.compile("\\d+\\.\\d+");
        Matcher matcherPrice = patternPrice.matcher(selectedRadioButton);
        BigDecimal price = new BigDecimal("0");
        if (matcherPrice.find()) {
            price = new BigDecimal(matcherPrice.group(0));
            totalSum = totalSum.add(price);
        }
        totalSum = totalSum.add(ingredientsSum);

        Pattern patternPizza = Pattern.compile("[A-Z]+\\s?[A-Z]+");
        Matcher matcherPizza = patternPizza.matcher(selectedRadioButton);
        if (matcherPizza.find()){
            addToScrollPaneBox(matcherPizza.group(0), price, ingredients);
        }
        checkStudentDiscount();
        new MaybeNextPizzaStage();
    }

    private void refreshPizzaMenu(){
        pizzaBox.getChildren().clear();
        pizzaGroup.selectToggle(null);

        pizzaBox.setPadding(new Insets(10, 10, 10, 10));
        pizzaBox.setSpacing(5);
        isCheckedPizza = false;

        String selectedRationText = ((RadioButton) pieGroup.getSelectedToggle()).getText();
        if ("Na cienkim".equals(selectedRationText)) {
            PizzaPieMenu italianMenu = new PizzaPieMenu();
            for (PizzaPie pizza: italianMenu.getItalianPizzasList() ) {
                pizzaBox.getChildren().add(new PizzaEntry(pizza.getName(), pizza.getPrice()));
            }
        } else if ("Na grubym".equals(selectedRationText)) {
            PizzaPieMenu americanMenu = new PizzaPieMenu();
            for (PizzaPie pizza: americanMenu.getAmericanPizzasList() ) {
                pizzaBox.getChildren().add(new PizzaEntry(pizza.getName(), pizza.getPrice()));
            }
        }
    }

    private void ingredientsMenu(){
        IngredientsMenu ingredientsMenu = new IngredientsMenu();
        for (Ingredient ingredient : ingredientsMenu.getIngredientsList()) {
            ingredientsBox.getChildren().add(new IngredientsEntry(ingredient.getName(), ingredient.getPrice()));
        }
    }

    private void deliveryOptions(){
        isCheckedDelivery = false;
        DeliveryOptions deliveryOptions = new DeliveryOptions();
        for (Delivery delivery : deliveryOptions.getDeliveryList()){
            deliveryOptionsBox.getChildren().add(new DeliveryEntry(delivery.getName(), delivery.getPrice()));
        }
    }

    private void addDeliveryCost(){
        String selectedRadioButton = ((RadioButton) deliveryGroup.getSelectedToggle()).getText();

        Pattern patternPrice = Pattern.compile("\\d+\\.\\d+");
        Matcher matcherPrice = patternPrice.matcher(selectedRadioButton);
        if (matcherPrice.find()) {
            totalSum = totalSum.subtract(prevDelivery);
            totalSum = totalSum.add(new BigDecimal(matcherPrice.group(0)));
            prevDelivery = new BigDecimal(matcherPrice.group(0));
        }
        setTotalPrize();
    }

    private void checkStudentDiscount(){
        addDeliveryCost();

        String selectedRationText = ((RadioButton) discountGroup.getSelectedToggle()).getText();
        if(selectedRationText.equals("Tak")){
            totalSum = totalSum.add(prevDiscount);
            BigDecimal discount = totalSum.multiply(new BigDecimal("0.2")).round(new MathContext(2, RoundingMode.CEILING));
            infoDiscount.setText("Została naliczona zniżka:\n" + "-20% = -" + discount + "zł");
            totalSum = totalSum.subtract(discount);
            prevDiscount = discount;
        }else {
            totalSum = totalSum.add(prevDiscount);
            prevDiscount = BigDecimal.ZERO;
            infoDiscount.setText("");
        }
        setTotalPrize();
    }

    private void addToScrollPaneBox(String pizza, BigDecimal priceOfPizza, String ingredients){
        String string = num.toString();

        if(ingredients.equals(""))
            string += (". " + pizza + "\t" + priceOfPizza + "zł\n");
        else
            string += (". " + pizza + "\t" + priceOfPizza + "zł\n\t" + ingredients + "\t" + ingredientsSum + "zł\n");

        textArea.appendText(string);
        scrollPaneBox.setContent(textArea);
        num++;
    }
}
