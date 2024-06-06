package Chess.Controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class PageController {

    public void topButton(Button ButtonN, Button ButtonJ, Button ButtonP) {

        ButtonN.setOnMouseClicked(actionEvent -> {
            changeScene("Chess.fxml", ButtonN);
        });
        ButtonJ.setOnMouseClicked(actionEvent -> {
            changeScene("Joueurs.fxml", ButtonJ);
        });
        ButtonP.setOnMouseClicked(actionEvent -> {
            changeScene("Parties.fxml", ButtonP);
        });
    }
    public void changeScene(String sceneName, Button button) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(sceneName));
            Stage stage = (Stage) button.getScene().getWindow();
            stage.setScene(new Scene(loader.load()));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}