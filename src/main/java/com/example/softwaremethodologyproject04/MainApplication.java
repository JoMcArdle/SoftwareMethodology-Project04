package com.example.softwaremethodologyproject04;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("VIEW/main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 700);
        scene.getStylesheets().add(getClass().getResource("CSS/application.css").toExternalForm());
        stage.setTitle("Monkey Donuts");
        stage.setScene(scene);
        stage.resizableProperty().setValue(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}