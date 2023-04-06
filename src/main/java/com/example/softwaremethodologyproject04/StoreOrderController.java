package com.example.softwaremethodologyproject04;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StoreOrderController {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    void backToMain(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("VIEW/main-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600, 700);
        scene.getStylesheets().add(getClass().getResource("CSS/application.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}

