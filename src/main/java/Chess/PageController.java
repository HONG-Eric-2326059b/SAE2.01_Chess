package Chess;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
public class PageController {

    private Stage stage;

    public void TopButton( Button ButtonN, Button ButtonJ) {

        ButtonN.setOnMouseClicked(actionEvent -> {
            changeScene("Chess.fxml", ButtonN);
        });
        ButtonJ.setOnMouseClicked(actionEvent -> {
            changeScene("Joueurs.fxml", ButtonJ);
        });
    }

    public void changeScene(String sceneName, Button button) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Chess.fxml"));
            Parent root = loader.load(); // Ensure you are not setting the controller here

            stage.setTitle("Chess Game");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}