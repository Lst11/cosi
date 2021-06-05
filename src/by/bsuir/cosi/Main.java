package by.bsuir.cosi;

import by.bsuir.cosi.drawing.Drawing;
import by.bsuir.cosi.drawing.DrawingWalsh;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Drawing group = new Drawing();
//todo    lab 3  - > class Points, DrawingWalsh, Points
//        GridPane grid = DrawingWalsh.drawWalsh();
//        stage.setScene(new Scene(grid));
        stage.setScene(new Scene(group));
        stage.show();
        stage.setResizable(true);
        stage.setFullScreen(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}