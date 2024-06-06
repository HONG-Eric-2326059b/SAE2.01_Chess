package Chess.Controllers;

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
    @FXML
    Label ColorWin;
    @FXML
    private Button ButtonJouer;

    @Override
    //initialize la page Victoire est Change le Label en fonction du gagnant
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (VictoireDesBlancs()) {
            ColorWin.setText("Victoire Des Blancs");
        } else {
            ColorWin.setText("Victoire Des Noirs");
        }
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
