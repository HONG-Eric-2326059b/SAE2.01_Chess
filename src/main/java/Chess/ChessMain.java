package Chess;

import Chess.Piece.Tour;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import Chess.Player;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ChessMain extends Application {
    @FXML
    private GridPane Plateau;
    public static final int tailleCase = 75;

    private static Scene scene;
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Chess.fxml"));
        scene = new Scene(loader.load());
        stage.setTitle("Chess");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}
