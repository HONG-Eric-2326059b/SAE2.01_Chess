package Chess.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class PageController {
    //fonction des button qui permet par la suite de les appeller dans les autres Controllers
    public void topButton(Button ButtonN, Button ButtonJ, Button ButtonP) {
        //Button Nouvelle Partie qui charge le fxml Principale
        ButtonN.setOnMouseClicked(actionEvent -> {
            changeScene("Chess.fxml", ButtonN);
        });
        // Button Joueurs qui permet de charger le fxml Joueurs
        ButtonJ.setOnMouseClicked(actionEvent -> {
            changeScene("Joueurs.fxml", ButtonJ);
        });
        //Button qui chager le fxml Parties
        ButtonP.setOnMouseClicked(actionEvent -> {
            changeScene("Parties.fxml", ButtonP);
        });
    }
    // Test de la fenetre Win
    public void TestButton(Button ButtonJouer){
        ButtonJouer.setOnAction(actionEvent -> {
            changeScene("Victoire.fxml", ButtonJouer);
        });
    }
    //reviens sur la page principale
    public static void replayB(Button Replay){
        Replay.setOnAction(actionEvent -> {
            changeScene("Chess.fxml", Replay);
        });
    }
    public static void Save(Button SaveP){
        SaveP.setOnAction(actionEvent -> {
            changeScene("sauvegardeFenetre.fxml", SaveP);
        });
    }

    //Permet de changer de scene en charger des fxml
    public static void changeScene(String sceneName, Button button) {
        try {
            FXMLLoader loader = new FXMLLoader(PageController.class.getClassLoader().getResource(sceneName));
            Stage stage = (Stage) button.getScene().getWindow();
            stage.setScene(new Scene(loader.load()));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}