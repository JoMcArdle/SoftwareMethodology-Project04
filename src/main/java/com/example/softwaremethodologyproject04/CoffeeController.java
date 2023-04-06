package com.example.softwaremethodologyproject04;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

public class CoffeeController implements Initializable {
    private double subtotal =0;
    private Stage stage;
    private Scene scene;
    private Parent root;
    private double shortCoffee  = 1.89;
    private double tallCoffee = 2.29;
    private double grandeCoffee = 2.69;
    private double ventiCoffee = 3.09;
    private double addInsPrice = 0.30;
    private int count =0;
    private Set<String> addsIn= new HashSet<>();

    @FXML
    private CheckBox sweetCream;
    @FXML
    private CheckBox mocha;
    @FXML
    private CheckBox frenchVanilla;
    @FXML
    private CheckBox caramel;
    @FXML
    private CheckBox irishCream;
    private String size;

    ObservableList<String> coffeeSize;
    @FXML
    private ImageView coffeImageView;
    @FXML
    private Image coffeImage;
    @FXML
    private ComboBox<String> coffeeComboBox;
    @FXML
    private Label coffeeQuantityLabel;
    @FXML
    private Button quantityDecrementButton;
    @FXML
    private TextField coffeePriceTextField;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        coffeeSize =  FXCollections.observableArrayList("Select size","Short", "Tall", "Grande", "Venti");
        displayDefaultImage();
        defaultCoffeeComboBox();
        hideDecrementButton();
        coffeePriceTextField.setText("$0.00");

    }

    @FXML
    void displayDefaultImage(){
            coffeImage = new Image("file:src/main/resources/com/example/softwaremethodologyproject04/IMAGES/coffee1.jpg", 673,398,false,false);
            coffeImageView.setImage(coffeImage);

    }


    @FXML
    void defaultCoffeeComboBox(){
        coffeeComboBox.setItems(coffeeSize);
        coffeeComboBox.getItems().addAll();
        coffeeComboBox.getSelectionModel().select(0);
    }

    @FXML
    private void hideDecrementButton(){
        if(coffeeQuantityLabel.getText().equals("0")){
            quantityDecrementButton.setVisible(false);
        }
    }
    @FXML
    void quantityDecrement(ActionEvent event){
        int i = Integer.parseInt(coffeeQuantityLabel.getText())-1;
        coffeeQuantityLabel.setText(Integer.toString(i));
        setTextFieldPrice();
        if(i==0){
            quantityDecrementButton.setVisible(false);
            setTextFieldPrice();
        }
    }
    @FXML
    void quantityIncrement(ActionEvent event){
        int i = Integer.parseInt(coffeeQuantityLabel.getText())+1;
        coffeeQuantityLabel.setText(Integer.toString(i));
        quantityDecrementButton.setVisible(true);
        setTextFieldPrice();

    }
    void resetTotal(){
        coffeePriceTextField.setText("0.00");
    }
    @FXML
    void removeAll(){
        if(!addsIn.isEmpty()){
            addsIn.removeAll(addsIn);
        }
    }

    @FXML
    void coffeeComboBoxAction(ActionEvent event){
        coffeeQuantityLabel.setText("0");
        if(coffeeComboBox.getSelectionModel().getSelectedItem().equals("Short")){
            removeAll();
            resetTotal();
            size = "Short";
            hideDecrementButton();
            unselectCheckBox();
        }else if(coffeeComboBox.getSelectionModel().getSelectedItem().equals("Tall")){
            removeAll();
            resetTotal();
            size = "Tall";
            hideDecrementButton();
            unselectCheckBox();
        }else if(coffeeComboBox.getSelectionModel().getSelectedItem().equals("Grande")){
            removeAll();
            resetTotal();
            size = "Grande";
            hideDecrementButton();
            unselectCheckBox();
        }else if(coffeeComboBox.getSelectionModel().getSelectedItem().equals("Venti")){
            removeAll();
            resetTotal();
            size = "Venti";
            hideDecrementButton();
            unselectCheckBox();
        }else if(coffeeComboBox.getSelectionModel().getSelectedItem().equals("Select size")){
            removeAll();
            resetTotal();
            hideDecrementButton();
            unselectCheckBox();
        }
    }
    @FXML
    void checkBoxes(ActionEvent event){
        sweetSelected();
        mochaSelected();
        frenchSelected();
        caramelSelected();
        irishSelected();

    }
    @FXML
    void setTextFieldPrice(){
        coffeePriceTextField.setText("$" + Double.toString(temporaryPrice()));
    }
    @FXML
    void sweetSelected(){
        if(sweetCream.isSelected()) {
            addsIn.add(sweetCream.getText().toString());
            setTextFieldPrice();
        }else{
            if(addsIn.contains(sweetCream.getText().toString())) {
                addsIn.remove(sweetCream.getText().toString());
                setTextFieldPrice();
         }
        }
    }
    @FXML
    void mochaSelected(){
        if(mocha.isSelected()) {
            addsIn.add(mocha.getText().toString());
            setTextFieldPrice();
        }else if(!mocha.isSelected()){
            if(addsIn.contains(mocha.getText().toString())) {
                addsIn.remove(mocha.getText().toString());
                setTextFieldPrice();
            }
        }
    }@FXML
    void frenchSelected(){
        if(frenchVanilla.isSelected()){
            addsIn.add(frenchVanilla.getText().toString());
            setTextFieldPrice();
        }else if(!frenchVanilla.isSelected()){
            if(addsIn.contains(frenchVanilla.getText().toString())){
                addsIn.remove(frenchVanilla.getText().toString());
                setTextFieldPrice();
            }
        }
    }
    @FXML
    void caramelSelected(){
        if(caramel.isSelected()){
            addsIn.add(caramel.getText().toString());
            setTextFieldPrice();
        }else if(!caramel.isSelected()){
            if(addsIn.contains(caramel.getText().toString())){
                addsIn.remove(caramel.getText().toString());
                setTextFieldPrice();
            }
        }
    }
    @FXML
    void irishSelected(){
        if(irishCream.isSelected()){
            addsIn.add(irishCream.getText().toString());
            setTextFieldPrice();
        }else if(!irishCream.isSelected()){
            if(!irishCream.isSelected()){
                addsIn.remove(irishCream.getText().toString());
                setTextFieldPrice();
            }
        }
    }

    @FXML
    void coffeeAddToOrder(ActionEvent event){
        int qty =Integer.parseInt(coffeeQuantityLabel.getText());
        if(qty>0 && !(coffeeComboBox.getSelectionModel().getSelectedItem().equals("Select size"))) {
            Coffee coffee = new Coffee();
            coffee.setQuantity(qty);
            coffee.setNumAddIns(addsIn.size());
            coffee.setCupSize(coffeeComboBox.getSelectionModel().getSelectedItem());
            for(String element: addsIn){
                coffee.addToList(element);
            }
            System.out.println(coffee +  " " + temporaryPrice() + " " + addsIn.size());
            coffeeQuantityLabel.setText("0");

        }
        hideDecrementButton();
        unselectCheckBox();
        resetTotal();
        removeAll();

    }


    @FXML
    void unselectCheckBox(){
        sweetCream.setSelected(false);
        mocha.setSelected(false);
        frenchVanilla.setSelected(false);
        caramel.setSelected(false);
        irishCream.setSelected(false);
    }
    @FXML
    double temporaryPrice(){
        int qty = Integer.parseInt(coffeeQuantityLabel.getText());
        if(coffeeComboBox.getSelectionModel().getSelectedItem().equals("Short") && qty>0){
            subtotal = (shortCoffee+  addsIn.size()*addInsPrice)*qty;
        }else if(coffeeComboBox.getSelectionModel().getSelectedItem().equals("Tall") && qty>0){
            subtotal = (tallCoffee+ addsIn.size()*addInsPrice)*qty;
        }else if(coffeeComboBox.getSelectionModel().getSelectedItem().equals("Grande") && qty>0){
            subtotal = (grandeCoffee +addsIn.size()*addInsPrice)*qty;

        }else if(coffeeComboBox.getSelectionModel().getSelectedItem().equals("Venti") && qty>0){
            subtotal = (ventiCoffee + addsIn.size()*addInsPrice)*qty;
        }else if(coffeeComboBox.getSelectionModel().getSelectedItem().equals("Select size")){
            subtotal = 0;
            unselectCheckBox();
        }else{
            subtotal = 0;
            unselectCheckBox();
        }
        DecimalFormat df = new DecimalFormat("0.00");
        subtotal = Double.parseDouble(df.format(subtotal));
        return subtotal;
    }

    @FXML void backToMain(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("VIEW/main-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600, 700);
        scene.getStylesheets().add(getClass().getResource("CSS/application.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

}
