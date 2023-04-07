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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class DonutsController implements Initializable {
    private double yeastPrice = 1.59;
    private double cakePrice = 1.79;
    private double holePrice = 0.39;
    ArrayList<MenuItem> menuItems = new ArrayList<>();

    ObservableList<String> items;
    ObservableList<String> yeastFlavors;
    ObservableList<String> cakeFlavors;
    ObservableList<String> holeFlavors;
    ObservableList<String> emptyFlavors;
    ObservableList<String> myDonutsList;
    private DonutHole donutHole;
    private CakeDonut cakeDonut;
    private YeastDonut yeastDonuts;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField donutsSubTotal;
    @FXML
    private ComboBox<String> donutsComboBox;
    @FXML
    private Label donutsQuantityLabel;
    @FXML
    private ImageView donutsImageView;

    @FXML
    Button quantityDecrementButton;
    @FXML
    Button addButton;
    @FXML
    private Image defaultImage;
    @FXML
    private Image yeastImage;
    @FXML
    private Image cakeImage;
    @FXML
    private Image holeImage;
    @FXML
    private ListView<String> donutsListView;
    @FXML
    private ListView<String> donutsOrderListView;
    private MainController mainController;
    public void setMainController (MainController controller){
        mainController = controller;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        items = FXCollections.observableArrayList("Select type", "Yeast Donut", "Cake Donut", "Donut Hole");
        yeastFlavors = FXCollections.observableArrayList("Jelly", "Glazed", "Chocolate Frosted", "Strawberry Frosted", "Sugar", "Lemon Filled");
        cakeFlavors = FXCollections.observableArrayList("Cinnamon Sugar", "Old Fashioned", "Blueberry");
        holeFlavors = FXCollections.observableArrayList("Cinnamon Munchkins", "Glazed Munchkins", "Jelly Munchkins");
        emptyFlavors = FXCollections.observableArrayList("");
        myDonutsList = FXCollections.observableArrayList();



        defaultComboBox();

        //This method will display the default image when the view is opened
        displayDefaultImage();

        hideDecrementButton();
    }

    @FXML
    private void hideDecrementButton() {
        if (donutsQuantityLabel.getText().equals("0")) {
            quantityDecrementButton.setVisible(false);
        }
    }

    @FXML
    void defaultComboBox() {
        donutsComboBox.setItems(items);
        donutsComboBox.getItems().addAll();
        donutsComboBox.getSelectionModel().select(0);
    }

    @FXML
    void donutsComboBoxAction(ActionEvent event) {
        donutsQuantityLabel.setText("0");
        if (donutsComboBox.getValue().equals("Yeast Donut")) {
            displayYeastImage();
            donutsListView.setItems(yeastFlavors);
            donutsListView.getItems().addAll();
        } else if (donutsComboBox.getValue().equals("Cake Donut")) {
            displayCakeImage();
            donutsListView.setItems(cakeFlavors);
            donutsListView.getItems().addAll();
        } else if (donutsComboBox.getValue().equals("Donut Hole")) {
            displayHoleImage();
            donutsListView.setItems(holeFlavors);
            donutsListView.getItems().addAll();
        } else {
            displayDefaultImage();
            donutsListView.setItems(emptyFlavors);
            donutsListView.getItems().addAll();
        }

    }

    @FXML
    void quantityDecrement(ActionEvent event) {
        int i = Integer.parseInt(donutsQuantityLabel.getText()) - 1;
        donutsQuantityLabel.setText(Integer.toString(i));
        if (i == 0) {
            quantityDecrementButton.setVisible(false);
        }

    }

    @FXML
    void quantityIncrement(ActionEvent event) {
        int i = Integer.parseInt(donutsQuantityLabel.getText()) + 1;
        donutsQuantityLabel.setText(Integer.toString(i));
        quantityDecrementButton.setVisible(true);
    }

    @FXML
    void displayDefaultImage() {
        defaultImage = new Image("file:src/main/resources/com/example/softwaremethodologyproject04/IMAGES/donuts2.jpg", 180, 100, false, false);
        donutsImageView.setImage(defaultImage);
        donutsImageView.setFitWidth(300);
        donutsImageView.setFitHeight(100);
    }

    @FXML
    void displayYeastImage() {
        yeastImage = new Image("file:src/main/resources/com/example/softwaremethodologyproject04/IMAGES/yeast.jpg", 180, 100, false, false);
        donutsImageView.setImage(yeastImage);
        donutsImageView.setFitWidth(300);
        donutsImageView.setFitHeight(100);
    }

    @FXML
    void displayCakeImage() {
        cakeImage = new Image("file:src/main/resources/com/example/softwaremethodologyproject04/IMAGES/cakeDonuts.jpeg", 180, 100, false, false);
        donutsImageView.setImage(cakeImage);
        donutsImageView.setFitWidth(300);
        donutsImageView.setFitHeight(100);
    }

    @FXML
    void displayHoleImage() {
        holeImage = new Image("file:src/main/resources/com/example/softwaremethodologyproject04/IMAGES/holeDonuts.jpg", 180, 100, false, false);
        donutsImageView.setImage(holeImage);
        donutsImageView.setFitWidth(300);
        donutsImageView.setFitHeight(100);
    }

    @FXML
    void addDonuts() {
        String s = donutsListView.getSelectionModel().getSelectedItem();
        int qty = Integer.parseInt(donutsQuantityLabel.getText());
        int i = donutsListView.getSelectionModel().getSelectedIndex();
        if (qty > 0 && s != null) {
            if (s.equals("Jelly") || s.equals("Glazed") || s.equals("Chocolate Frosted") ||
                    s.equals("Strawberry Frosted") || s.equals("Sugar") ||
                    s.equals("Lemon Filled")) {
                myDonutsList.add(s + " " + donutsQuantityLabel.getText()); //Add the item and quantity to the cart observable list
                donutsOrderListView.setItems(myDonutsList); //Adding the values of the observable list to the cart listview
                donutsOrderListView.getItems().addAll();


            } else if (s.equals("Cinnamon Sugar") || s.equals("Old Fashioned") || s.equals("Blueberry")) {
                myDonutsList.add(s + " " + donutsQuantityLabel.getText()); //Add the item and quantity to the cart observable list
                donutsOrderListView.setItems(myDonutsList); //Adding the values of the observable list to the cart listview
                donutsOrderListView.getItems().addAll();

            } else if (s.equals("Cinnamon Munchkins") || s.equals("Glazed Munchkins") || s.equals("Jelly Munchkins")) {
                myDonutsList.add(s + " " + donutsQuantityLabel.getText()); //Add the item and quantity to the cart observable list
                donutsOrderListView.setItems(myDonutsList); //Adding the values of the observable list to the cart listview
                donutsOrderListView.getItems().addAll();

            }
            donutsListView.getItems().remove(i);
            donutsQuantityLabel.setText("0");
            quantityDecrementButton.setVisible(false);
            setTemporaryPrice();
        }

    }

    @FXML
    private void setTemporaryPrice() {
        double subTotal = 0;
        int yeastQuantity = 0;
        int cakeQuantity = 0;
        int holeQuantity = 0;
        String[] arr;
        for (String s : myDonutsList) {
            arr = s.split("\\s+");
            String flavor = "";
            if (arr.length == 2) {
                flavor = arr[0];
            } else if (arr.length == 3) {
                flavor = arr[0] + " " + arr[1];
            }

            if (flavor.equals("Jelly") || flavor.equals("Glazed") || flavor.equals("Chocolate Frosted") ||
                    flavor.equals("Strawberry Frosted") || flavor.equals("Sugar") ||
                    flavor.equals("Lemon Filled")) {
                int quantity = Integer.parseInt(arr[arr.length - 1]);
                yeastQuantity += quantity;

            } else if (flavor.equals("Cinnamon Sugar") || flavor.equals("Old Fashioned") || flavor.equals("Blueberry")) {
                int quantity = Integer.parseInt(arr[arr.length - 1]);
                cakeQuantity += quantity;
            } else if (flavor.equals("Cinnamon Munchkins") || flavor.equals("Glazed Munchkins") || flavor.equals("Jelly Munchkins")) {
                int quantity = Integer.parseInt(arr[arr.length - 1]);
                holeQuantity += quantity;
            }

        }
        DecimalFormat df = new DecimalFormat("0.00");
        subTotal = yeastQuantity * yeastPrice + cakeQuantity * cakePrice + holeQuantity * holePrice;
        String stringSubTotal = "$" + df.format(subTotal);
        donutsSubTotal.setText(stringSubTotal);

    }

    @FXML
    void removeDonuts() {
        double subTotal = Double.parseDouble(donutsSubTotal.getText().substring(1));
        String s = donutsOrderListView.getSelectionModel().getSelectedItem();
        String[] stringArr = s.split("\\s+");
        String flavor = "";
        int i = donutsOrderListView.getSelectionModel().getSelectedIndex();
        int qty = 0;
        if (stringArr.length == 2) {
            flavor = stringArr[0];
            qty = Integer.parseInt(stringArr[1]);
        } else if (stringArr.length == 3) {
            flavor = stringArr[0] + " " + stringArr[1];
            qty = Integer.parseInt(stringArr[2]);
        }
        if (flavor.equals("Jelly") || flavor.equals("Glazed") || flavor.equals("Chocolate Frosted") ||
                flavor.equals("Strawberry Frosted") || flavor.equals("Sugar") ||
                flavor.equals("Lemon Filled")) {
            subTotal = subTotal - (yeastPrice * qty);
            yeastFlavors.add(flavor);

        } else if (flavor.equals("Cinnamon Sugar") || flavor.equals("Old Fashioned") || flavor.equals("Blueberry")) {
            subTotal = subTotal - (cakePrice * qty);
            cakeFlavors.add(flavor);

        } else if (flavor.equals("Cinnamon Munchkins") || flavor.equals("Glazed Munchkins") || flavor.equals("Jelly Munchkins")) {
            subTotal = subTotal - (holePrice * qty);
            holeFlavors.add(flavor);
        }
        if (subTotal < 0) {
            subTotal = 0;
        }
        donutsOrderListView.getItems().remove(i);
        DecimalFormat df = new DecimalFormat("0.00");
        String stringSubTotal = "$" + df.format(subTotal);
        donutsSubTotal.setText(stringSubTotal);

    }
    @FXML
    private void removeList(){
            myDonutsList.clear();
            donutsOrderListView.setItems(myDonutsList);
    }

    @FXML
    void addToOrder(ActionEvent event) {
        String donutType = "";
        int quantity = 0;
        for (String donut : myDonutsList) {
            String[] arr = donut.split("\\s+");
            if (arr.length == 2) {
                donutType = arr[0];
                quantity = Integer.parseInt(arr[1]);
                if (donutsComboBox.getSelectionModel().getSelectedItem().equals("Yeast Donut")) {
                    yeastDonuts = new YeastDonut();
                    yeastDonuts.setFlavor(donutType);
                    yeastDonuts.setQuantity(quantity);
                    yeastDonuts.setPrice(yeastDonuts.getPrice());
                    mainController.orderBasket.add(yeastDonuts);
                    System.out.println(mainController.orderBasket.toString(yeastDonuts));
                } else if (donutsComboBox.getSelectionModel().getSelectedItem().equals("Cake Donut")) {
                    cakeDonut = new CakeDonut();
                    cakeDonut.setFlavor(donutType);
                    cakeDonut.setQuantity(quantity);
                    cakeDonut.setPrice(cakeDonut.getCakePrice());
                    mainController.orderBasket.add(cakeDonut);
                    System.out.println(mainController.orderBasket.toString(cakeDonut));


                } else if (donutsComboBox.getSelectionModel().getSelectedItem().equals("Donut Hole")) {
                    donutHole = new DonutHole();
                    donutHole.setFlavor(donutType);
                    donutHole.setQuantity(quantity);
                    donutHole.setPrice(donutHole.getDonutHolePrice());
                    mainController.orderBasket.add(donutHole);
                    System.out.println(mainController.orderBasket.toString(donutHole));
                }

            } else if (arr.length == 3) {
                donutType = arr[0] + " " + arr[1];
                quantity = Integer.parseInt(arr[2]);
                if (donutsComboBox.getSelectionModel().getSelectedItem().equals("Yeast Donut")) {
                    yeastDonuts = new YeastDonut();
                    yeastDonuts.setFlavor(donutType);
                    yeastDonuts.setQuantity(quantity);
                    yeastDonuts.setPrice(yeastDonuts.getPrice());
                    mainController.orderBasket.add(yeastDonuts);
                    System.out.println(mainController.orderBasket.toString(yeastDonuts));
                } else if (donutsComboBox.getSelectionModel().getSelectedItem().equals("Cake Donut")) {
                    cakeDonut = new CakeDonut();
                    cakeDonut.setFlavor(donutType);
                    cakeDonut.setQuantity(quantity);
                    cakeDonut.setPrice(cakeDonut.getCakePrice());
                    mainController.orderBasket.add(cakeDonut);
                    System.out.println(mainController.orderBasket.toString(cakeDonut));

                } else if (donutsComboBox.getSelectionModel().getSelectedItem().equals("Donut Hole")) {
                    donutHole = new DonutHole();
                    donutHole.setFlavor(donutType);
                    donutHole.setQuantity(quantity);
                    donutHole.setPrice(donutHole.getDonutHolePrice());
                    mainController.orderBasket.add(donutHole);
                    System.out.println(mainController.orderBasket.toString(donutHole));
                }

            }
        }
        donutsQuantityLabel.setText("0");
        removeList();
    }

    @FXML
    void backToMain(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("VIEW/main-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600, 700);
        scene.getStylesheets().add(getClass().getResource("CSS/application.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

}
