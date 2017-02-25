package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Event Handling");

        try {


            FXMLLoader loader = new FXMLLoader();
            AnchorPane mainScreen = (AnchorPane) loader.load(Main.class.getResource("view/EventHandling.fxml"));
            Scene scene = new Scene(mainScreen);

            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
