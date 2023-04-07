package com.example.softwaremethodologyproject04;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button bOrderCoffee;

    @FXML
    private Button bOrderDonuts;

    @FXML
    private Button bStoreOrder;

    @FXML
    private Button bUserOrder;
    @FXML
    private Image donutImage;
    @FXML
    private Image coffeeImage;
    @FXML
    private Image userOrderImage;
    @FXML
    private Image storeOrderImage;
    @FXML
    private ImageView orderDonutsImageView;
    @FXML
    private ImageView orderCoffeeImageView;
    @FXML
    private ImageView userOrderImageView;

    @FXML
    private ImageView storeOrderImageView;

    public Order orderBasket = new Order();
    private DonutsController donutsController;

    public void setDonutsController(DonutsController controller){
        donutsController = controller;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



        setDonutsImage(); //Order Donuts button

        setCoffeeImage(); //Order Coffee button

        setUserOrderImage(); //Order My Order button

        setStoreOrderImage(); //Order Store Orders button

    }
    @FXML
    protected void orderDonuts(ActionEvent event) throws IOException {
        stage = new Stage();
        BorderPane root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VIEW/donuts-view.fxml"));
            root = (BorderPane)loader.load();
            scene = new Scene(root, 600, 700);
            stage.setScene(scene);
            scene.getStylesheets().add(getClass().getResource("CSS/donuts.css").toExternalForm());
            stage.show();
            DonutsController donutsController = loader.getController();
            donutsController.setMainController(this);
        }catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading View1.fxml.");
            alert.setContentText("Couldn't load View1.fxml.");
            alert.showAndWait();
        }
    }
    @FXML
    private void orderCoffee(ActionEvent event) throws IOException {
        stage = new Stage();
        BorderPane root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VIEW/coffee-view.fxml"));
            root = (BorderPane)loader.load();
            scene = new Scene(root, 600, 700);
            stage.setScene(scene);
            scene.getStylesheets().add(getClass().getResource("CSS/coffee.css").toExternalForm());
            stage.show();
            CoffeeController coffeeController = loader.getController();
            coffeeController.setMainController(this);
        }catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading View1.fxml.");
            alert.setContentText("Couldn't load View1.fxml.");
            alert.showAndWait();
        }
    }
    @FXML
    private void yourOrder(ActionEvent event) throws IOException {
        // FXMLLoader loader = new FXMLLoader(getClass().getResource("user-order-view.fxml"));
        stage = new Stage();
        BorderPane root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VIEW/user-order-view.fxml"));
            root = (BorderPane)loader.load();
            scene = new Scene(root, 600, 700);
            stage.setScene(scene);
            scene.getStylesheets().add(getClass().getResource("CSS/userOrder.css").toExternalForm());
            stage.show();
            UserOrderController userOrderController = loader.getController();
            userOrderController.setMainController(this);
        }catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading View1.fxml.");
            alert.setContentText("Couldn't load View1.fxml.");
            alert.showAndWait();
        }

    }
    @FXML
    private void storeOrder(ActionEvent event) throws IOException {
        stage = new Stage();
        BorderPane root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VIEW/store-order-view.fxml"));
            root = (BorderPane)loader.load();
            scene = new Scene(root, 600, 700);
            stage.setScene(scene);
            scene.getStylesheets().add(getClass().getResource("CSS/storeOrder.css").toExternalForm());
            stage.show();
            StoreOrderController storeOrderController = loader.getController();
            storeOrderController.setMainController(this);
        }catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading View1.fxml.");
            alert.setContentText("Couldn't load View1.fxml.");
            alert.showAndWait();
        }

    }
    /*************************************     Helper Methods    *************************************/
    @FXML
    private void setDonutsImage(){
        donutImage = new Image("file:src/main/resources/com/example/softwaremethodologyproject04/IMAGES/donuts2.jpg");
        orderDonutsImageView = new ImageView();
        orderDonutsImageView.setImage(donutImage);
        orderDonutsImageView.setFitWidth(180);
        orderDonutsImageView.setFitHeight(100);
        bOrderDonuts.setContentDisplay(ContentDisplay.TOP);
        bOrderDonuts.setGraphic(orderDonutsImageView);

    }
    @FXML
    private void setCoffeeImage(){
        coffeeImage = new Image("file:src/main/resources/com/example/softwaremethodologyproject04/IMAGES/coffee1.jpg");
        orderCoffeeImageView = new ImageView();
        orderCoffeeImageView.setImage(coffeeImage);
        orderCoffeeImageView.setFitWidth(180);
        orderCoffeeImageView.setFitHeight(100);
        bOrderCoffee.setContentDisplay(ContentDisplay.TOP);
        bOrderCoffee.setGraphic(orderCoffeeImageView);

    }
    @FXML
    private void setUserOrderImage(){
         userOrderImage = new Image("file:src/main/resources/com/example/softwaremethodologyproject04/IMAGES/cart.jpg");
        userOrderImageView = new ImageView();
        userOrderImageView.setImage(userOrderImage);
        userOrderImageView.setFitWidth(180);
        userOrderImageView.setFitHeight(100);
        bUserOrder.setContentDisplay(ContentDisplay.TOP);
        bUserOrder.setGraphic(userOrderImageView);

    }
    @FXML
    private void setStoreOrderImage(){
        storeOrderImage = new Image("file:src/main/resources/com/example/softwaremethodologyproject04/IMAGES/storeOrder.jpg");
        storeOrderImageView = new ImageView();
        storeOrderImageView.setImage(storeOrderImage);
        storeOrderImageView.setFitWidth(180);
        storeOrderImageView.setFitHeight(100);
        bStoreOrder.setContentDisplay(ContentDisplay.TOP);
        bStoreOrder.setGraphic(storeOrderImageView);

    }
    public Order getList(){
        return orderBasket;
    }
}


