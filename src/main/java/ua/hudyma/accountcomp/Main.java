package ua.hudyma.accountcomp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 230);
        stage.setTitle("Compare bank accounts ::: Hudyma v.1");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}