package Chess.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class VictoireController implements Initializable {
    private Stage stage;
    private Scene scene;
    @FXML
    Label ColorWin;
    @FXML
    private Button ButtonJouer;
    @FXML
    private Button Replay;
    @FXML
    private Button SaveP;
    @FXML
    void SaveGame(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("sauvegardeFenetre.fxml"));
        scene = new Scene(loader.load());
        stage.setTitle("Chess");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    //initialize la page Victoire est Change le Label en fonction du gagnant
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (VictoireDesBlancs()) {
            ColorWin.setText("Victoire Des Blancs");
        } else {
            ColorWin.setText("Victoire Des Noirs");
        }
        PageController.replayB(Replay);
        PageController.Save(SaveP);
    }
    //revoie True pour les blanc
    public boolean VictoireDesBlancs() {
        return true;
    }
    //renvoie false pour les noirs
    public boolean VictoireDesNoirs() {
        return false;
    }

}
